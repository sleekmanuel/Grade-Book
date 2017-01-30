import java.util.*;

public class GradeBook {
	static HashMap<String,HashMap<String,Integer>> hm = new HashMap<String,HashMap<String, Integer>> ();
	static HashMap<String,Integer> hm2 = new HashMap<String,Integer>();
	static HashMap<String,Integer> hm3 = new HashMap<String,Integer>();

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StructData();
	}

	public static void StructData(){
		System.out.println();
		System.out.println("To enter students grade in the system ENTER 1");
		System.out.println("To display a student's in the system Enter 2 ");
		System.out.println("To delete student from the system ENTER 3");
		System.out.println("To display all students ENTER 4");
		System.out.println("To alter student's grade ENTER 5");
		System.out.println("To stop program ENTER 6");
		System.out.print(" Pick an option from the menu: ");
		int p= sc.nextInt();

		switch(p){
		case 1:
			UseStruct(Subjects());
		case 2:
			DispStud();
		case 3:
			DeleteStud();
		case 4:
			DispAll();
		case 5:
			AlterGrade();
		case 6:
			System.out.println("You just exited the System System!");
			break;
		default :
            System.out.println("Invalid option");
            StructData();
		}

	}

	/*
	 * Follow 5 method Structures the input of students grade into a system using HashMaps
	 * you can add a student, display a students grades or delete student from system
	 */
		// Method for inputing the classes the students take. it is assumed that the students are all taking the same classes
		public static String[] Subjects(){
			System.out.println("Enter number of courses: ");
			int numCourse= sc.nextInt();
			String []Courses = new String[numCourse];
			sc.nextLine();
			for( int t = 0; t< numCourse;t++){
				System.out.println("Enter Course "+ (t+1)+ ": ");
				String name = sc.nextLine();
				Courses[t] = name;
			}
			return Courses;
		}

		// Enters students and there grades
		@SuppressWarnings("unchecked")
		public static void UseStruct(String[]Courses){
			System.out.println();
			System.out.println("Enter Number of Students: ");
			int NoOfStud = sc.nextInt();
			for(int q = 0; q< NoOfStud;q++){
				System.out.println();
				System.out.println("Enter Student"+(q+1)+" name: ");
				sc.nextLine();
				String StudName = sc.nextLine();
				for( int w = 0; w < Courses.length; w++){
					//LinkedList<Integer> list = new LinkedList<Integer>();
					System.out.println("Enter Grade for "+ Courses[w]+ ": ");
					int grade = sc.nextInt();
					//list.add(grade);
					hm2.put(Courses[w], grade);
				}
				hm3 = (HashMap<String, Integer>) hm2.clone();
				hm.put(StudName, hm3);
				hm2.clear();
			}
			StructData();
		}
		// Display a student's grades
		public static void DispStud(){
			boolean right = false;
		do{
			try{
				sc.nextLine();
				System.out.println();
				System.out.println("Enter Students Name for his/her grades: ");
				String StudName = sc.nextLine();
				if(hm.containsKey(StudName)){
					System.out.println(hm.get(StudName));
					right = true;
			}
			else{
				int ans = 2/0;
				System.out.println(ans);
			}
		}catch(Exception e){
			System.out.println("STUDENT'S NAME DOESN'T EXIST IN SYSTEM. Press Enter to continue");
		}
	}while(!right);

			StructData();
		}
		// Deletes the student from the system
		public static void DeleteStud(){
			boolean right = false;
				do{
					try{
						sc.nextLine();
						System.out.println();
						System.out.println("Enter Students Name delete his/her grades: ");
						String StudName = sc.nextLine();
						if(hm.containsKey(StudName)){
						hm.remove(StudName);
						System.out.println(StudName+ " has been deleted from the system.");
						right = true;}
						else{
							int ans = 2/0;
							System.out.println(ans);
						}
					}catch(Exception e){
						System.out.println("STUDENT'S NAME DOESN'T EXIST IN SYSTEM. Press Enter to continue");
					}
				}while(!right);

				StructData();
		}
		// Displays all students and Grades in the System
		public static void DispAll(){
			System.out.println(hm.entrySet());

			StructData();
		}

		public static void AlterGrade(){


			int loop = 1;
			do {
			     try{ 
				sc.nextLine();
				System.out.println("Enter Students name: ");
				String StudName = sc.nextLine();
				System.out.println("Enter Course to alter: ");
				String Course = sc.nextLine();
				System.out.println("Enter new grade: ");
				int newGrade = sc.nextInt();
				hm.get(StudName).remove(Course);
				hm.get(StudName).put(Course, newGrade);
				loop = 2;
				}catch(Exception e){
				System.out.println("AN ERROR OCCURED. REREAD THE INSTRUCTION");
			         }
			}while(loop==1);
			StructData();

		}

}
