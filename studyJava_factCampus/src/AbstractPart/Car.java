package AbstractPart;

public abstract class Car {
	
	abstract void start();
	abstract void go();
	abstract void stop();
	abstract void end();
	
	public void washCar() {
		System.out.println("������ �մϴ�.");
	}
	// ���ø� �޼��� : ��ü ����� �帧�� �����Ѵ�
	// final�� ���� �Ͽ� ���� Ŭ�������� �����Ҽ� ������ �Ѵ�
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
		System.out.println("Sonata �õ��� �մϴ�.");
	}

	@Override
	void go() {
		System.out.println("Sonata �޸��ϴ�.");
	}

	@Override
	void stop() {
		System.out.println("Sonata ����ϴ�.");
	}

	@Override
	void end() {
		System.out.println("Sonata �õ��� ���ϴ�.");	
	}
}

class Avante extends Car {
	@Override
	void start() {
		System.out.println("Avante �õ��� �մϴ�.");	
	}

	@Override
	void go() {
		System.out.println("Avante �޸��ϴ�.");		
	}

	@Override
	void stop() {
		System.out.println("Avante ����ϴ�.");
	}

	@Override
	void end() {
		System.out.println("Avante �õ��� ���ϴ�.");	
	}
}

class Grandeur extends Car {
	@Override
	void start() {
		System.out.println("Grandeur �õ��� �մϴ�.");
	}

	@Override
	void go() {
		System.out.println("Grandeur �޸��ϴ�.");	
	}

	@Override
	void stop() {
		System.out.println("Grandeur ����ϴ�.");
	}

	@Override
	void end() {
		System.out.println("Grandeur �õ��� ���ϴ�.");	
	}
}

class Genesis extends Car {
	@Override
	void start() {
		System.out.println("Genesis �õ��� �մϴ�.");	
	}

	@Override
	void go() {
		System.out.println("Genesis �޸��ϴ�.");	
	}

	@Override
	void stop() {
		System.out.println("Genesis ����ϴ�.");
	}

	@Override
	void end() {
		System.out.println("Genesis �õ��� ���ϴ�.");	
	}
}