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
				if(method.getPassword(replaceId).equals(password)) { //비밀번호가 같다면 새로운 데이터 받기
				System.out.println("새로운 ID를 입력하세요");
				String newId = sc.next();
				System.out.println("새로운 password를 입력하세요");
				String newPs = sc.next();
				System.out.println("새로운 사는지역을 입력하세요");
				String newAr = sc.next();
				System.out.println("새로운 LV를 입력하세요");
				int newLv = sc.nextInt();
				method.replace(newId, newPs, newAr, newLv, replaceId); //새로운 정보를 replace함수로 보냄.
				} else { //수정할 아이디의 비밀번호가 다르다면 예외처리 
					System.out.println("비밀번호가 다릅니다!");
				}
				
			} else if(menuNum == 4) {
				System.out.println("삭제하실 ID를 입력하세요:");
				String deleteId = sc.next();
				System.out.println("삭제하실 아이디의 비밀번호를 입력하세요:");
				String password = sc.next();
				if(method.getPassword(deleteId).equals(password)) { //아이디를 받아 password 확인하고 해당 아이디의 비밀번호와 일치 시 실행 
				method.DeleteId(deleteId);
				} else { //비밀번호가 같지 않으면 실패
					System.out.println("비밀번호가 다릅니다. 다시 시도하세요.");
				}
			}  else if(menuNum == 5) {
				listMenu(); //메소드로 list메뉴 보여주기
				int listNum = sc.nextInt(); //내부 리스트 넘버 받기
				if(listNum == 1) {
					method.idList();
				} else if(listNum == 2) {
					method.dateList();
				} else {
					System.out.println("잘못 입력! 다시 실행하세요!"); //1,2 번 외 다른 메뉴를 선택 시 오류 메세지
				}
			} 	else if(menuNum == 6) {
				System.out.println("종료합니다."); //종료
				oc = false;
			} else {
				System.out.println("잘못입력!"); //잘못 입력 시 다시 메뉴로 돌아감.
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
