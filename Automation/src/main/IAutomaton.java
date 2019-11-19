package main;

public interface IAutomaton {

	int getSerieSize();

	int getD();

	void setD(int value);

	int getR();

	void setR(int value);

	int getC();

	void setC(int value);

	int getResult();

	// Mange nextInput et change le state de l'automate en conséquence
	void applyNextInput(char nextInput);

}
