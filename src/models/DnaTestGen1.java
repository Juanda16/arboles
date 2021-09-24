package models;


public class DnaTestGen1  extends DnaTest{

   
    @Override
    public int compareTo(DnaTest test) {
        DnaTest t = (DnaTest) test;
        String pb = String.valueOf( t.gen1);
        String pa = index;
        return pa.compareTo(pb);

    }
    
}