package caiquan;
import java.util.Scanner;
//��Ϸ����
public class GameRoom {
	//���� ���Ƿ��ƣ� ���ߣ�������Ϸ����ң�����ţ��������ƣ��������룬����
	private String weapon;
	private HumanPlayer player1 = null;
	private comPlayer player2 = null;
	private int roomid;
	private String roomname = "�������";
	private String roompass;
	public GameRoom(String roomname, String roompass)
	{
		if(!("admin".equalsIgnoreCase(roomname)&&"123".equalsIgnoreCase(roompass))) {
			System.out.println("������Ϣ�������");
		}
		this.setRomename(roomname);
		initgame();
		startgame(roomname,roompass);
		endgame();
	}
	//��������ʼ��Ϸ����ʼ����Ϸ����ʾ��Ϸ���˵���ѡ�������ж�
	public void initgame()
	{
		//1ʵ������Ϸ��Ҷ���
		//2ѡ���ɫ
		player1 = new HumanPlayer();
		player2 = new comPlayer();
		//2��Ϸ����������
		//�磺�����ļ�  �����ݲ�
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
	System.out.println("��Ϸ���سɹ���");
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
		while(true) {//˫����ȭ
		System.out.println(player1.getName()+"���ȭ��");
		//player1.setFist(new Scanner(System.in).nextInt());
		//Scanner input = new 
		player1.setFist(input.nextInt());
		int fist1 = player1.getFist();
		player2.getFist();
		int fist2 = player2.getFist();
		//�ж���Ӯ
		int result = judge(fist1,fist2);
		if(result==-1) {
			System.out.println("���"+player1.getName()+"ʤ����");
			player1.sendMessage(HumanPlayer.messageTypewin);
			player2.sendMessage(comPlayer.messageTypelose);
		}else if(result==0) {
			System.out.println("ƽ�֣�");
			player1.sendMessage(HumanPlayer.messageTypefist);
			player2.sendMessage(comPlayer.messageTypefist);
		}else {
			System.out.println("���"+player2.getName()+"ʤ����");
			player1.sendMessage(HumanPlayer.messageTypelose);
			player2.sendMessage(comPlayer.messageTypewin);
		}
		//��ӡ���
		System.out.println("�Ƿ������");
		String answer = new Scanner(System.in).next();
		if("!y".equalsIgnoreCase(answer)) {
			break;
		}
		}
	}
	public void showmenu()
	{
		System.out.println("��Ϸ����˵�\n"+"��ӭ����"+"��"+roomname+"������");
	}
	public void choicerole()
	{
		System.out.println("�Է���ɫ��1-�⽨2-����3-����4-����");
		System.out.println("��ѡ��");
		
		int choice = input.nextInt();
		String[] namearry = {"�⽨","����","����","����"};
		player2.setName(namearry[choice-1]);
		player1.setName("ԭҰ֩��");
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
		return -1;//���1ʤ��
		}else
		{
			player1.setScore(player1.getScore()-1);
			player2.setScore(player2.getScore()+1);
		}
		return 1;
	}
	public void endgame()
	{
		System.out.println("��Ϸ��������ӭ�´�������");
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