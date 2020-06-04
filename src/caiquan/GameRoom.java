package caiquan;
import java.util.Scanner;
//游戏房间
public class GameRoom {
	//属性 ：记分牌， 道具，参与游戏的玩家，房间号，房间名称，房间密码，，，
	private String weapon;
	private HumanPlayer player1 = null;
	private comPlayer player2 = null;
	private int roomid;
	private String roomname = "天地世界";
	private String roompass;
	public GameRoom(String roomname, String roompass)
	{
		if(!("admin".equalsIgnoreCase(roomname)&&"123".equalsIgnoreCase(roompass))) {
			System.out.println("房间信息输入错误！");
		}
		this.setRomename(roomname);
		initgame();
		startgame(roomname,roompass);
		endgame();
	}
	//方法：开始游戏，初始化游戏，显示游戏主菜单，选择任务，判断
	public void initgame()
	{
		//1实例化游戏玩家对象
		//2选择角色
		player1 = new HumanPlayer();
		player2 = new comPlayer();
		//2游戏的其他属性
		//如：配置文件  花花草草
		for (int i = 0; i < 30; i++) {
			System.out.print("*");
			try {
				Thread.sleep(50);
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println();
	System.out.println("游戏加载成功！");
	}
	Scanner input = new Scanner(System.in);
	//private String ;
	public void startgame(String roomname,String roompass)
	{
		
		showmenu();
		choicerole();
		gameing();
	}
	private void gameing() {
		while(true) {//双方出拳
		System.out.println(player1.getName()+"请出拳：");
		//player1.setFist(new Scanner(System.in).nextInt());
		//Scanner input = new 
		player1.setFist(input.nextInt());
		int fist1 = player1.getFist();
		player2.getFist();
		int fist2 = player2.getFist();
		//判断输赢
		int result = judge(fist1,fist2);
		if(result==-1) {
			System.out.println("玩家"+player1.getName()+"胜出！");
			player1.sendMessage(HumanPlayer.messageTypewin);
			player2.sendMessage(comPlayer.messageTypelose);
		}else if(result==0) {
			System.out.println("平局！");
			player1.sendMessage(HumanPlayer.messageTypefist);
			player2.sendMessage(comPlayer.messageTypefist);
		}else {
			System.out.println("玩家"+player2.getName()+"胜出！");
			player1.sendMessage(HumanPlayer.messageTypelose);
			player2.sendMessage(comPlayer.messageTypewin);
		}
		//打印结果
		System.out.println("是否继续：");
		String answer = new Scanner(System.in).next();
		if("!y".equalsIgnoreCase(answer)) {
			break;
		}
		}
	}
	public void showmenu()
	{
		System.out.println("游戏规则菜单\n"+"欢迎加入"+"《"+roomname+"》房间");
	}
	public void choicerole()
	{
		System.out.println("对方角色：1-封建2-妮妮3-正南4-阿呆");
		System.out.println("请选择：");
		
		int choice = input.nextInt();
		String[] namearry = {"封建","妮妮","正南","阿呆"};
		player2.setName(namearry[choice-1]);
		player1.setName("原野蜘蛛");
		System.out.println(player1.getName()+"vs"+player2.getName());
		/*do
		{
		}while();*/
	}
	public int judge(int fist1,int fist2)
	{
		if(fist1 == fist2)
		{
		return 0;}
		if(fist1 ==1&&fist2==3||fist1==2&&fist2==1||fist1==3&&fist2==2)
		{
		player1.setScore(player1.getScore()+1);
		player2.setScore(player2.getScore()-1);
		return -1;//玩家1胜利
		}else
		{
			player1.setScore(player1.getScore()-1);
			player2.setScore(player2.getScore()+1);
		}
		return 1;
	}
	public void endgame()
	{
		System.out.println("游戏结束，欢迎下次再来！");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public String getRomename() {
		return roomname;
	}
	public void setRomename(String romename) {
		this.roomname = romename;
	}
	public String getRoompass() {
		return roompass;
	}
	public void setRoompass(String roompass) {
		this.roompass = roompass;
	}
}