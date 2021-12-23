package Main;
import java.util.Scanner;




public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MethodAll method = new MethodAll();
		
		//menu 보여주기
		
		boolean oc = true;
		while(oc) {
			menu();
			int menuNum = sc.nextInt();
			if(menuNum == 1) {
				System.out.println("ID를 입력해주세요.");
				String id = sc.next();
				if(method.idCheck(id)==true) {
					System.out.println("사용중인 아이디 입니다!");	
				} else {
					System.out.println("PassWord를 입력해주세요.");
					String password = sc.next();
					System.out.println("사시는 지역을 입력해주세요.");
					String area = sc.next();
					method.insert(id, password, area);
				}
				
			} else if(menuNum == 2) {
				searchMenu();
				int searchNum = sc.nextInt();
				
				if(searchNum == 1) { //primary key로 검색
					System.out.println("검색하실 PK를 입력하세요");
					int primarykey = sc.nextInt();
					method.primarySearch(primarykey);
					
				} else if(searchNum ==2) { //id로 검색
					System.out.println("찾으실 ID를 입력해주세요");
					String searchId = sc.next();
					if(method.idCheck(searchId)) {
						method.search(searchId);							
					} else {
						System.out.println("찾으시는 아이디가 없습니다!");
					}
					
				} else if (searchNum == 3) { //등록일로 검색
					System.out.println("등록하신 날짜를 입력해주세요");
					String date = sc.next();
					method.dateSearch(date);
				}
				
			} else if(menuNum == 3) {
				System.out.println("수정하실 ID를 입력하세요");
				String replaceId = sc.next();
				System.out.println("관리자 비빌먼호를 입력해주세요");
				String password = sc.next();
				if(method.getPassword(replaceId).equals(password)) {
				System.out.println("새로운 ID를 입력하세요");
				String newId = sc.next();
				System.out.println("새로운 password를 입력하세요");
				String newPs = sc.next();
				System.out.println("새로운 사는지역을 입력하세요");
				String newAr = sc.next();
				System.out.println("새로운 LV를 입력하세요");
				int newLv = sc.nextInt();
				method.replace(newId, newPs, newAr, newLv, replaceId);
				} else {
					System.out.println("비밀번호가 다릅니다!");
				}
				
			} else if(menuNum == 4) {
				System.out.println("삭제하실 ID를 입력하세요:");
				String deleteId = sc.next();
				method.DeleteId(deleteId);
			}  else if(menuNum == 5) {
				listMenu();
				int listNum = sc.nextInt();
				if(listNum == 1) {
					method.idList();
				} else if(listNum == 2) {
					method.dateList();
				}
			} 	else if(menuNum == 6) {
				System.out.println("종료합니다.");
				oc = false;
			} else {
				System.out.println("잘못입력!");
				continue;
			}
		}
		
	}
	//메뉴 메소드
	static void menu(){
		System.out.println("1.등록");
		System.out.println("2.조회");
		System.out.println("3.수정");
		System.out.println("4.삭제");
		System.out.println("5.목록");
		System.out.println("6.종료");
	}
	
	static void searchMenu() {
		System.out.println("1.primary key로 검색");
		System.out.println("2.이름으로 검색");
		System.out.println("3.등록일로 검색");
	}
	
	static void listMenu() {
		System.out.println("1.이름을 정렬");
		System.out.println("2.등록일로 정렬");
	}
	
}
