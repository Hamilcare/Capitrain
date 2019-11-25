package producer.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.BlockingQueue;

import alphabet.Alphabet;
import main.Main;
import producer.IProducer;

public class FileReaderProducer implements IProducer {

	BlockingQueue<Alphabet> queue;
	String pathToDataFile;
	BufferedReader br;
	int previousValue;

	public FileReaderProducer(BlockingQueue<Alphabet> blockingQueue, String pathToDatafile) throws IOException {
		this.queue = blockingQueue;
		this.pathToDataFile = pathToDatafile;
	}

	protected void prepareProducer() throws IOException {
		br = Files.newBufferedReader(Paths.get(pathToDataFile));
		previousValue = br.read();
	}

	protected void produce() throws IOException, InterruptedException {
		int nextValue;
		Alphabet correspondingChar;
		while (br.ready()) {
			nextValue = getNextInt();
			if (previousValue < nextValue) {
				correspondingChar = (Alphabet.MORE);
			} else if (previousValue > nextValue) {
				correspondingChar = (Alphabet.LESS);
			} else {
				correspondingChar = (Alphabet.EQUALS);
			}
//			System.out.println("J'empile " + correspondingChar);
//			queue.add(correspondingChar);
			queue.put(correspondingChar);
			previousValue = nextValue;
		}

	}

	protected int getNextInt() throws IOException {
		return br.read();
	}

	@Override
	public void run() {
		try {
			prepareProducer();
			produce();
			Main.producerIsAlive = false;
			System.out.println("Traduction terminée");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
