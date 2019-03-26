import java.io.*;
import java.util.*;
class Student implements Comparable<Student>
{
    int id;
    float gpa;
    float physics;
    float chemistry;
    float maths;
    float computer;
    float specialExams;
    String pref1;    
    String pref2;    
    String pref3;    
    public void setId(int id)
    {
        this.id=id;   
    }
    public void setGPA(float gpa)
    {
       this.gpa=gpa;
       
    }
    public void setPhysics(float phy)
    {
        this.physics=phy;
    }
    public void setSpecialExams(float exam)
    {
        this.specialExams=exam;
    }
    public void setChemistry(float chem)
    {
        this.chemistry=chem;
    }
    public void setMaths(float maths)
    {
        this.maths=maths;
    }
    public void setComputer(float comp)
    {
        this.computer=comp;
    }
    public float getComputer()
    {
        return this.computer;

    }
    public void setPreference1(String str)
    {
        this.pref1=str;
    }
     public void setPreference2(String str)
    {
        this.pref2=str;
    }
      public void setPreference3(String str)
    {
        this.pref3=str;
    }
    public float getGPA()
    {
        return this.gpa;
    }
     public int getId()
     {
         return this.id;
         
     }
     public float getPhysics()
     {
         return this.physics;
     }
      public float getChemistry()
     {
         return this.chemistry;
     }
       public float getMaths()
     {
         return this.maths;
     }
        public float getSpecialExams()
     {
         return this.specialExams;
     }
           public String getPreference1()
    {
        return this.pref1;
    }
         public String getPreference2()
    {
        return this.pref2;
    }
            public String getPreference3()
    {
        return this.pref3;
    }
    public int compareTo(Student s2)
    {
        if(this.gpa<s2.gpa)
            return 1;
        else if(this.gpa>s2.gpa)
            return -1;
        else 
            return 0;
    }
     
     
}
public class ExampleQueue
{
        Student physics[]=new Student[15];
        Student t;
        Student chemistry[]=new Student[10];
        Student engneering[]=new Student[15];
        Student biotech[]=new Student[10];
        Student  maths[]=new Student[15];
        int ma=0,phy=0,chem=0,bio=0,eng=0;
        void arrangePrefenceWise(PriorityQueue<Student> p)
        {
            System.out.println("INSIDE THE FUNCTION");
            for(int i=0;i<98;i++)
            {
              t=p.poll();
                if(t.pref1.equals("Physics") && phy<15)
                {
                  System.out.println("physics");
                
                  physics[phy]=t;
                  phy++;
                }
                else if(t.pref1.equals("Chemistry") && chem<10)
                {
                  System.out.println("chemistry");
                  chemistry[chem]=t;
                  chem++;
                }
                else if(t.pref1.equals("Mathematics") && ma<15)
                  {
                    System.out.println("maths");
                    maths[ma]=t;
                    ma++;
                  }                
                  else if(t.pref1.equals("Biotech") && bio<10)
                  {
                    System.out.println("biotech");
                    biotech[bio]=t;
                    bio++;
                  }
                  else if(t.pref1.equals("Engineering") && eng<15)
                  {
                    System.out.println("engneering");
                    engneering[eng]=t;
                    eng++;
                  }                             
              }
          }
          void showStudent(Student s[])
          {
            for(int i=0;i<s.length;i++)
            {
                System.out.println(" "+
                s[i].getId()+" "+
                s[i].getGPA()+" "+
                s[i].getPhysics()+" "+
                s[i].getChemistry()+" "+
                s[i].getMaths()+" "+
                s[i].getComputer()+" "+
                s[i].getSpecialExams()+" "+
                s[i].getPreference1()+" "+
                s[i].getPreference2()+" "+
                s[i].getPreference3());
            }
          }
  public static void main(String args[]) throws Exception
    {
      ExampleQueue eq=new ExampleQueue();
        PriorityQueue<Student> pq=new PriorityQueue<Student>(); //Defination of PriorityQueue Object 
        Student s[]=new Student[200];
        BufferedReader in = new BufferedReader(new FileReader("Startup.txt"));
    String str;

List<String> list = new ArrayList<String>();
while((str = in.readLine()) != null){
    list.add(str);
}

String[] stringArr=list.toArray(new String[0]);
        String prop[];
    /*------------------------------------Conversion to student Object-----------------------------------*/
     for(int i=0;i<stringArr.length;i++)
     {
            prop=stringArr[i].split(" ");
            s[i]=new Student();
            s[i].setId(Integer.parseInt(prop[0]));
            s[i].setGPA(Float.parseFloat(prop[1]));
            s[i].setPhysics(Float.parseFloat(prop[2]));
            s[i].setChemistry(Float.parseFloat(prop[3]));
            s[i].setMaths(Float.parseFloat(prop[4]));
            s[i].setComputer(Float.parseFloat(prop[5]));
            s[i].setSpecialExams(Float.parseFloat(prop[6]));
            s[i].setPreference1(prop[7]);
            s[i].setPreference2(prop[8]);
            s[i].setPreference3(prop[9]);
            /* System.out.println(" "+
            s[i].getId()+" "+
            s[i].getGPA()+" "+
            s[i].getPhysics()+" "+
            s[i].getChemistry()+" "+
            s[i].getMaths()+" "+
            s[i].getComputer()+" "+
            s[i].getSpecialExams()+" "+
            s[i].getPreference1()+" "+
            s[i].getPreference2()+" "+
            s[i].getPreference3());*/
     }
     /*-------------------Insertion into priority Queue------------------------*/
     Student temp;
     for(int i=0;i<stringArr.length;i++)
        pq.offer(s[i]);
      
     eq.arrangePrefenceWise(pq);

   /* --------------Traversal in priority Queue based on GPA of the student-----------------------
     for(Student t : pq)
     {
         System.out.println(" "+
            t.getId()+" "+
            t.getGPA()+" "+
            t.getPhysics()+" "+
            t.getChemistry()+" "+
            t.getMaths()+" "+
            t.getComputer()+" "+
            t.getSpecialExams()+" "+
            t.getPreference1()+" "+
            t.getPreference2()+" "+
            t.getPreference3());

     }*/
   /* for(int i=0;i<stringArr.length;i++)
    {
        temp=pq.poll();
        System.out.println(" "+
            temp.getId()+" "+
            temp.getGPA()+" "+
            temp.getPhysics()+" "+
            temp.getChemistry()+" "+
            temp.getMaths()+" "+
            temp.getComputer()+" "+
            temp.getSpecialExams()+" "+
            temp.getPreference1()+" "+
            temp.getPreference2()+" "+
            temp.getPreference3());

    }*/
    System.out.println("--------------Physics Students------------");
    eq.showStudent(eq.physics);
    System.out.println("--------------Chemistry Students------------");
    eq.showStudent(eq.chemistry);
    System.out.println("--------------Maths Students------------");
    eq.showStudent(eq.maths);
    System.out.println("--------------Engneering Students------------");
    eq.showStudent(eq.engneering);
    System.out.println("--------------Biotech Students------------");
    eq.showStudent(eq.biotech);
    

   

    }
}