package caiquan;

public class HumanPlayer {
	//��̬����
	public static final int messageTypefist = 1;
	//Ӯ�ó���
	public static final int messageTypewin = 2;
	//��ĳ���
	public static final int messageTypelose = 3;
	
		public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getFist() {
		return fist;
	}
	public void setFist(int fist) {
		this.fist = fist;
	}
	public void show() {
		// TODO Auto-generated method stub
		System.out.println(name+score+fist);
	}
	//�������
	//���ԣ����� ������ ��������ȭ����ɫ��Ӧ����Ч
	private String name;
	private int score;
	private int fist;
	//.......
	private String[] fistwords = {
		"���йⲨ" ,"12345","23456","34567","56789"	
	};
	private String[] winwords = {
		"����˭","��ȭ��","����","quanjinchuji1","���Ż�����Ÿ�"	
	};
	private String[] losewords = {
		"ͨ���ɹ���·��ͬ","�ȵ���ˮ��ȥ","������ǲ���","�ҵ���","���µ���"	
	};
	
	//���� ����ӡ���Ʒ��� �� ���Ŷ�Ӧ����Ч �������Ի�̨�� �� ��ȭ
	//���ݴ�������ͣ������ӡ�������ͣ���Ӧ�ľ�̬����
	public void sendMessage(int msgtype) {
		//����һ��0-4֮��������
		int index = ((int)(Math.random()*1000))%5;
		String message = null;
		switch(msgtype)
		{
		case messageTypefist:
			message = fistwords[index];
			break;
		case messageTypewin:
			message = winwords[index];
			
			break;
		case messageTypelose:
			message = losewords[index];
			break;
		
		}
		System.out.println(message);
	};
}
