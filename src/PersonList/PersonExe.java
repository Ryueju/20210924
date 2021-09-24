package PersonList;

//기능구현하기
//1.등록 2.조회 3. 수정 4. 삭제 5. 종료
//3.수정은 배열의 주소값으로 수정처리할 것(뭐더라 이해 살짝 안됨 ㅜ..
//4.삭제는 배열의 인덱스 값으로 삭제 처리.. (오키..

//personExe 로 기능구현하기
//personApp main personExe호출

public class PersonExe {
	
	private static PersonExe singleton = new PersonExe();
	private Person[] persons;
	private Person person;
	
	private PersonExe() {
		
		persons = new Person[100];
		persons[0] = new Person("류이주", Gender.WOMAN, "010-1234-5678");
		persons[1] = new Person("류연주", Gender.WOMAN, "010-1234-3456");
		persons[2] = new Person("장연주", Gender.WOMAN, "010-5577-3456");
		persons[3] = new Student("장현성", Gender.MAN, "010-5577-5678", "서울대");
		persons[4] = new Student("강주성", Gender.MAN, "010-9999-8888", "하버드대");
		persons[5] = new Worker("강혜주", Gender.WOMAN, "010-1234-8888", "삼성전자");

	}
	
	public static PersonExe getInstance() {
		return singleton;
	}
	
	public void execute() {
		while(true) {
			System.out.println("-------------------------------------");
			System.out.println("1 등록 | 2 조회 | 3 수정 | 4 삭제 | 5 종료 ");
			System.out.println("-------------------------------------");

			int menu = ScanUtil.readInt(" 메뉴 선택 >>>");
				if(menu ==1) {
					System.out.println(" 1 등록 ");
					addPerson();
					
				} else if(menu ==2) {
					System.out.println(" 2 조회 ");
					showList();
					
				} else if(menu ==3 ) {
					System.out.println(" 3 수정 ");
					modify();
					
				} else if(menu ==4 ) {
					System.out.println(" 4 삭제 ");
					delete();
					
				} else if(menu ==5 ) {
					System.out.println(" 5 종료 ");
					break;
				}
		
		}
		System.out.println(" 프로그램을 종료합니다. ");

	}
	
	public void addPerson() {
		System.out.println("1 친구 2 학교친구 3 직장동료 ");
		int choice = ScanUtil.readInt("메뉴를 선택하세요");
		
		String name = ScanUtil.readStr("친구 이름을 입력하세요");
		Gender gender = gender();
		String phone = ScanUtil.readStr("연락처를 입력하세요");
		Person person = null;
		
		
		
		if(choice ==1) {
				
			person = new Person(name,gender,phone);
			} else if(choice ==2) {
				String school = ScanUtil.readStr("학교를 입력하세요");
				
				person = new Student(name,gender,phone,school);
			} else if(choice ==3) {
				String company = ScanUtil.readStr("회사를 입력하세요");
				person = new Worker(name,gender,phone,company);
			}
			for(int i = 0; i < persons.length; i++) {
				if(persons[i] == null) {
					persons[i] = person;
					break;
				}
			}
			System.out.println(" 등록 완료");
			}
	
	public void showList() {
		String name = ScanUtil.readStr("조회할 이름을 입력하세요");
		Gender gender = gender();
			for(int i = 0; i< persons.length; i++) {
				if(persons[i] !=null) {
					
					if(!name.equals("") && gender.equals("")) { //이름이랑 성별
						if(persons[i].getName().indexOf(name)!=-1 && persons[i].getGender() == gender)
							System.out.println(persons[i].toString());
							
					} else if(!name.equals("")) { //이름만
						if(persons[i].getName().indexOf(name) != -1)
							System.out.println(persons[i].toString());
						
					}else if(gender != null)	{
						if(persons[i].getGender() == gender)
							System.out.println(persons[i].toString());
						
					}else {
						System.out.println(persons[i].toString());
					}
				}
			}
				
			}
	public void modify() {
		for(int i = 0; i < persons.length; i++) {
			if(persons[i] !=null)
		
			System.out.println("["+ i + "]" + persons[i].toString());
			
	}
		//FriendExe참고하면서 하기
		int num = ScanUtil.readInt("수정할 친구를 선택하세요"); 
		String phone = ScanUtil.readStr("바꿀 번호를 선택하세요"); //""
		if(!phone.equals(""))
		persons[num].setPhone(phone);
		
		if(persons[num] instanceof Student) {
			String school = ScanUtil.readStr("바꿀 학교를 입력하세요."); //""
			if(!school.equals(""))
				((Student) persons[num]).setSchool(school);
		} else if(persons[num] instanceof Worker) {
			String company = ScanUtil.readStr("바꿀 회사를 입력하세요.");
			if(!company.equals(""))
				((Worker) persons[num]).setCompany(company);
			
		}
		System.out.println("수정 완료");
	
	}
	private void delete() {
		System.out.println(" 등록된 목록 ");
		for( int i =0; i<persons.length; i++) {
			if(persons[i] !=null)
				System.out.println("[" + i + "]" + persons[i]);
		}
		
		int num = ScanUtil.readInt("삭제할 번호를 입력하세요");
		if( persons[num] !=null) {
			persons[num] = null;
			System.out.println("삭제 완료");
			
		} else if(persons[num] ==null) {
			System.out.println("입력하신 정보가 없습니다.");
		}
		
	
	}
	
	
		
		


	private Gender gender() {
		String gender = ScanUtil.readStr("성별을 선택하세요. <남자는 M, 여자는 F>");
		if(gender.equals("M")) {
			return Gender.MAN;
		}else if(gender.equals("F")) {
			return Gender.WOMAN;
		}else {
			System.out.println("남자는M, 여자는F입니다. 다시 입력해주세요");
			return null;
			
		}
			
		// TODO Auto-generated method stub
	}
	
	}

