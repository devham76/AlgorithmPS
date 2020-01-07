package AbstractPart;

public abstract class Car {
	
	abstract void start();
	abstract void go();
	abstract void stop();
	abstract void end();
	
	public void washCar() {
		System.out.println("세차를 합니다.");
	}
	// 템플릿 메서드 : 전체 기능의 흐름을 설정한다
	// final로 정의 하여 하위 클래스에서 변경할수 없도록 한다
	public final void run() {
		start();
		go();
		stop();
		end();
		washCar();
	}
}

class Sonata extends Car {

	@Override
	void start() {
		System.out.println("Sonata 시동을 켭니다.");
	}

	@Override
	void go() {
		System.out.println("Sonata 달립니다.");
	}

	@Override
	void stop() {
		System.out.println("Sonata 멈춥니다.");
	}

	@Override
	void end() {
		System.out.println("Sonata 시동을 끕니다.");	
	}
}

class Avante extends Car {
	@Override
	void start() {
		System.out.println("Avante 시동을 켭니다.");	
	}

	@Override
	void go() {
		System.out.println("Avante 달립니다.");		
	}

	@Override
	void stop() {
		System.out.println("Avante 멈춥니다.");
	}

	@Override
	void end() {
		System.out.println("Avante 시동을 끕니다.");	
	}
}

class Grandeur extends Car {
	@Override
	void start() {
		System.out.println("Grandeur 시동을 켭니다.");
	}

	@Override
	void go() {
		System.out.println("Grandeur 달립니다.");	
	}

	@Override
	void stop() {
		System.out.println("Grandeur 멈춥니다.");
	}

	@Override
	void end() {
		System.out.println("Grandeur 시동을 끕니다.");	
	}
}

class Genesis extends Car {
	@Override
	void start() {
		System.out.println("Genesis 시동을 켭니다.");	
	}

	@Override
	void go() {
		System.out.println("Genesis 달립니다.");	
	}

	@Override
	void stop() {
		System.out.println("Genesis 멈춥니다.");
	}

	@Override
	void end() {
		System.out.println("Genesis 시동을 끕니다.");	
	}
}