package implemenation;

import interfaces.Tyres;

public class BridgeStoneTyres implements Tyres {

	@Override
	public String rotate() {
		return "Vehicle moving with the help of BridgeStone tyres";
	}

	@Override
	public String stop() {
		return "Vehicle stopped with the help of BridgeStone tyres";
	}
}