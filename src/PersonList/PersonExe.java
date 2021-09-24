package PersonList;

//��ɱ����ϱ�
//1.��� 2.��ȸ 3. ���� 4. ���� 5. ����
//3.������ �迭�� �ּҰ����� ����ó���� ��(������ ���� ��¦ �ȵ� ��..
//4.������ �迭�� �ε��� ������ ���� ó��.. (��Ű..

//personExe �� ��ɱ����ϱ�
//personApp main personExeȣ��

public class PersonExe {
	
	private static PersonExe singleton = new PersonExe();
	private Person[] persons;
	private Person person;
	
	private PersonExe() {
		
		persons = new Person[100];
		persons[0] = new Person("������", Gender.WOMAN, "010-1234-5678");
		persons[1] = new Person("������", Gender.WOMAN, "010-1234-3456");
		persons[2] = new Person("�忬��", Gender.WOMAN, "010-5577-3456");
		persons[3] = new Student("������", Gender.MAN, "010-5577-5678", "�����");
		persons[4] = new Student("���ּ�", Gender.MAN, "010-9999-8888", "�Ϲ����");
		persons[5] = new Worker("������", Gender.WOMAN, "010-1234-8888", "�Ｚ����");

	}
	
	public static PersonExe getInstance() {
		return singleton;
	}
	
	public void execute() {
		while(true) {
			System.out.println("-------------------------------------");
			System.out.println("1 ��� | 2 ��ȸ | 3 ���� | 4 ���� | 5 ���� ");
			System.out.println("-------------------------------------");

			int menu = ScanUtil.readInt(" �޴� ���� >>>");
				if(menu ==1) {
					System.out.println(" 1 ��� ");
					addPerson();
					
				} else if(menu ==2) {
					System.out.println(" 2 ��ȸ ");
					showList();
					
				} else if(menu ==3 ) {
					System.out.println(" 3 ���� ");
					modify();
					
				} else if(menu ==4 ) {
					System.out.println(" 4 ���� ");
					delete();
					
				} else if(menu ==5 ) {
					System.out.println(" 5 ���� ");
					break;
				}
		
		}
		System.out.println(" ���α׷��� �����մϴ�. ");

	}
	
	public void addPerson() {
		System.out.println("1 ģ�� 2 �б�ģ�� 3 ���嵿�� ");
		int choice = ScanUtil.readInt("�޴��� �����ϼ���");
		
		String name = ScanUtil.readStr("ģ�� �̸��� �Է��ϼ���");
		Gender gender = gender();
		String phone = ScanUtil.readStr("����ó�� �Է��ϼ���");
		Person person = null;
		
		
		
		if(choice ==1) {
				
			person = new Person(name,gender,phone);
			} else if(choice ==2) {
				String school = ScanUtil.readStr("�б��� �Է��ϼ���");
				
				person = new Student(name,gender,phone,school);
			} else if(choice ==3) {
				String company = ScanUtil.readStr("ȸ�縦 �Է��ϼ���");
				person = new Worker(name,gender,phone,company);
			}
			for(int i = 0; i < persons.length; i++) {
				if(persons[i] == null) {
					persons[i] = person;
					break;
				}
			}
			System.out.println(" ��� �Ϸ�");
			}
	
	public void showList() {
		String name = ScanUtil.readStr("��ȸ�� �̸��� �Է��ϼ���");
		Gender gender = gender();
			for(int i = 0; i< persons.length; i++) {
				if(persons[i] !=null) {
					
					if(!name.equals("") && gender.equals("")) { //�̸��̶� ����
						if(persons[i].getName().indexOf(name)!=-1 && persons[i].getGender() == gender)
							System.out.println(persons[i].toString());
							
					} else if(!name.equals("")) { //�̸���
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
		//FriendExe�����ϸ鼭 �ϱ�
		int num = ScanUtil.readInt("������ ģ���� �����ϼ���"); 
		String phone = ScanUtil.readStr("�ٲ� ��ȣ�� �����ϼ���"); //""
		if(!phone.equals(""))
		persons[num].setPhone(phone);
		
		if(persons[num] instanceof Student) {
			String school = ScanUtil.readStr("�ٲ� �б��� �Է��ϼ���."); //""
			if(!school.equals(""))
				((Student) persons[num]).setSchool(school);
		} else if(persons[num] instanceof Worker) {
			String company = ScanUtil.readStr("�ٲ� ȸ�縦 �Է��ϼ���.");
			if(!company.equals(""))
				((Worker) persons[num]).setCompany(company);
			
		}
		System.out.println("���� �Ϸ�");
	
	}
	private void delete() {
		System.out.println(" ��ϵ� ��� ");
		for( int i =0; i<persons.length; i++) {
			if(persons[i] !=null)
				System.out.println("[" + i + "]" + persons[i]);
		}
		
		int num = ScanUtil.readInt("������ ��ȣ�� �Է��ϼ���");
		if( persons[num] !=null) {
			persons[num] = null;
			System.out.println("���� �Ϸ�");
			
		} else if(persons[num] ==null) {
			System.out.println("�Է��Ͻ� ������ �����ϴ�.");
		}
		
	
	}
	
	
		
		


	private Gender gender() {
		String gender = ScanUtil.readStr("������ �����ϼ���. <���ڴ� M, ���ڴ� F>");
		if(gender.equals("M")) {
			return Gender.MAN;
		}else if(gender.equals("F")) {
			return Gender.WOMAN;
		}else {
			System.out.println("���ڴ�M, ���ڴ�F�Դϴ�. �ٽ� �Է����ּ���");
			return null;
			
		}
			
		// TODO Auto-generated method stub
	}
	
	}

