package transducer;

import search.aggregator.IAggregator;
import search.aggregator.impl.SumAggregator;
import search.feature.IFeature;
import search.feature.impl.OneFeature;
import search.occurence.Occurence;
import translate.ITranslator;
import translate.Translate;

import java.util.List;
import java.util.regex.MatchResult;

public class RegexSearcherWithTransducter {
    private ITranslator translator;
    PeakTransducer peakTransducer;
    private IAggregator aggregator;
    private IFeature feature;
    private List<Integer> rawInput;

    public RegexSearcherWithTransducter(ITranslator translator){
        this.translator = translator;
        this.peakTransducer = new PeakTransducer();
        this.aggregator = new SumAggregator("sum");
        this.feature = new OneFeature("one");
        this.rawInput = translator.getTextToTranslate();
    }

    public int search(){
        Output output;
        char letter;
        int maybeB = -1;
        int maybeA = -1;
        int nbFound = 0;
        for (int i=0; i < translator.getTranslatedText().length(); i++) {
            letter = translator.getTranslatedText().charAt(i);
            output = this.peakTransducer.compute(letter);
            if(output == Output.MAYBEB){
                maybeB = i;
            }
            else if(output == Output.MAYBEA){
                maybeA = i;
            }
            else if(output == Output.FOUND){
                nbFound++;
                if(maybeB > -1)
                    aggregator.compute(feature.compute(
                            Occurence.buildOccurenceFromMatch(rawInput.subList(maybeB, i))
                    ));
            }
//            else if (output == Output.OUTA){
//                nbFound++;
//                if(maybeA > -1 && maybeB > -1){
//                    aggregator.compute(feature.compute(
//                            Occurence.buildOccurenceFromMatch(rawInput.subList(maybeB, maybeA))
//                    ));
//                }
//                maybeA = -1;
//                maybeB = -1;
//            }
        }

        System.out.println("Nombre de peak trouvés : " + nbFound);

        return aggregator.getValue();
    }

}
