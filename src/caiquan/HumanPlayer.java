package caiquan;

public class HumanPlayer {
	//静态常量
	public static final int messageTypefist = 1;
	//赢得常量
	public static final int messageTypewin = 2;
	//输的常量
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
	//人类玩家
	//属性，名称 ，分数 ，所出的拳，角色对应的音效
	private String name;
	private int score;
	private int fist;
	//.......
	private String[] fistwords = {
		"动感光波" ,"12345","23456","34567","56789"	
	};
	private String[] winwords = {
		"还有谁","猜拳嘛","超神","quanjinchuji1","吃着火锅唱着歌"	
	};
	private String[] losewords = {
		"通往成功的路不同","等到潮水退去","夏天就是不好","我的天","天下倒数"	
	};
	
	//方法 ，打印名称分数 ， 播放对应的音效 ，所个性化台词 ， 出拳
	//根据传入的类型，随机打印对性类型，对应的静态变量
	public void sendMessage(int msgtype) {
		//生成一个0-4之间的随机数
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
