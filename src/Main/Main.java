package Main;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MethodAll method = new MethodAll();
		
		//menu �����ֱ�
		
		boolean oc = true;
		while(oc) {
			menu();
			int menuNum = sc.nextInt();
			if(menuNum == 1) {
				System.out.println("ID�� �Է����ּ���.");
				String id = sc.next();
				if(method.idCheck(id)==true) {
					System.out.println("������� ���̵� �Դϴ�!");	
				} else {
					System.out.println("PassWord�� �Է����ּ���.");
					String password = sc.next();
					System.out.println("��ô� ������ �Է����ּ���.");
					String area = sc.next();
					method.insert(id, password, area);
				}
				
			} else if(menuNum == 2) {
				searchMenu();
				int searchNum = sc.nextInt();
				
				if(searchNum == 1) { //primary key�� �˻�
					System.out.println("�˻��Ͻ� PK�� �Է��ϼ���");
					int primarykey = sc.nextInt();
					method.primarySearch(primarykey);
					
				} else if(searchNum ==2) { //id�� �˻�
					System.out.println("ã���� ID�� �Է����ּ���");
					String searchId = sc.next();
					if(method.idCheck(searchId)) {
						method.search(searchId);							
					} else {
						System.out.println("ã���ô� ���̵� �����ϴ�!");
					}
					
				} else if (searchNum == 3) { //����Ϸ� �˻�
					System.out.println("����Ͻ� ��¥�� �Է����ּ���");
					String date = sc.next();
					method.dateSearch(date);
				}
				
			} else if(menuNum == 3) {
				System.out.println("�����Ͻ� ID�� �Է��ϼ���");
				String replaceId = sc.next();
				System.out.println("������ �����ȣ�� �Է����ּ���");
				String password = sc.next();
				if(method.getPassword(replaceId).equals(password)) { //��й�ȣ�� ���ٸ� ���ο� ������ �ޱ�
				System.out.println("���ο� ID�� �Է��ϼ���");
				String newId = sc.next();
				System.out.println("���ο� password�� �Է��ϼ���");
				String newPs = sc.next();
				System.out.println("���ο� ��������� �Է��ϼ���");
				String newAr = sc.next();
				System.out.println("���ο� LV�� �Է��ϼ���");
				int newLv = sc.nextInt();
				method.replace(newId, newPs, newAr, newLv, replaceId); //���ο� ������ replace�Լ��� ����.
				} else { //������ ���̵��� ��й�ȣ�� �ٸ��ٸ� ����ó�� 
					System.out.println("��й�ȣ�� �ٸ��ϴ�!");
				}
				
			} else if(menuNum == 4) {
				System.out.println("�����Ͻ� ID�� �Է��ϼ���:");
				String deleteId = sc.next();
				System.out.println("�����Ͻ� ���̵��� ��й�ȣ�� �Է��ϼ���:");
				String password = sc.next();
				if(method.getPassword(deleteId).equals(password)) { //���̵� �޾� password Ȯ���ϰ� �ش� ���̵��� ��й�ȣ�� ��ġ �� ���� 
				method.DeleteId(deleteId);
				} else { //��й�ȣ�� ���� ������ ����
					System.out.println("��й�ȣ�� �ٸ��ϴ�. �ٽ� �õ��ϼ���.");
				}
			}  else if(menuNum == 5) {
				listMenu(); //�޼ҵ�� list�޴� �����ֱ�
				int listNum = sc.nextInt(); //���� ����Ʈ �ѹ� �ޱ�
				if(listNum == 1) {
					method.idList();
				} else if(listNum == 2) {
					method.dateList();
				} else {
					System.out.println("�߸� �Է�! �ٽ� �����ϼ���!"); //1,2 �� �� �ٸ� �޴��� ���� �� ���� �޼���
				}
			} 	else if(menuNum == 6) {
				System.out.println("�����մϴ�."); //����
				oc = false;
			} else {
				System.out.println("�߸��Է�!"); //�߸� �Է� �� �ٽ� �޴��� ���ư�.
				continue;
			}
		}
		
	}
	//�޴� �޼ҵ�
	static void menu(){
		System.out.println("1.���");
		System.out.println("2.��ȸ");
		System.out.println("3.����");
		System.out.println("4.����");
		System.out.println("5.���");
		System.out.println("6.����");
	}
	
	static void searchMenu() {
		System.out.println("1.primary key�� �˻�");
		System.out.println("2.�̸����� �˻�");
		System.out.println("3.����Ϸ� �˻�");
	}
	
	static void listMenu() {
		System.out.println("1.�̸��� ����");
		System.out.println("2.����Ϸ� ����");
	}
	
}
