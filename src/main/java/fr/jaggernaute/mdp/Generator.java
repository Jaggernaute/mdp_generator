package fr.jaggernaute.mdp;

public class Generator{

    HelloApplication app = new HelloApplication();
    int length;
    char[] tChar = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    char[] tNb = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char[] tSpe = {'&', 'é', '(', '-', 'è', 'ç', '_', 'à', '@', '['};
    int alea;
    char aleaChar;
    int binaryBox = app.binaryBox;

    Generator(){
    }

     private int aleaGen(int length){
         int aleaInt = (int)Math.floor(Math.random()*(length +1)+0);
         return aleaInt;
     }

     private char aleaChar(int binaryBox){
        switch(binaryBox) {
            case 1 -> aleaChar = tChar[aleaGen(tChar.length - 1)];
            case 10 -> aleaChar = tNb[aleaGen(tNb.length - 1)];
            case 100 -> aleaChar = tSpe[aleaGen(tSpe.length - 1)];
            case 11 -> {
                alea = aleaGen(length);
                switch (aleaGen(1)) {
                    case 0 -> aleaChar = tChar[aleaGen(tChar.length - 1)];
                    case 1 -> aleaChar = tNb[aleaGen(tNb.length - 1)];
                }
            }
            case 110 -> {
                alea = aleaGen(length);
                switch (aleaGen(1)) {
                    case 0 -> aleaChar = tNb[aleaGen(tNb.length - 1)];
                    case 1 -> aleaChar = tSpe[aleaGen(tChar.length - 1)];
                }
            }
            case 101 -> {
                alea = aleaGen(length);
                switch (aleaGen(1)) {
                    case 0 -> aleaChar = tChar[aleaGen(tChar.length - 1)];
                    case 1 -> aleaChar = tSpe[aleaGen(tSpe.length - 1)];
                }
            }
            case 111 -> {
                alea = aleaGen(length);
                switch (aleaGen(2)) {
                    case 0 -> aleaChar = tChar[aleaGen(tChar.length - 1)];
                    case 1 -> aleaChar = tNb[aleaGen(tNb.length - 1)];
                    case 2 -> aleaChar = tSpe[aleaGen(tSpe.length - 1)];
                }
            }
        }
        return aleaChar;
    }

     public String mdpGen(int length, int binaryBox){

         String mdp = ("");
         for(int i = 0; i < length; i++){
            char chara = aleaChar(binaryBox);
             mdp = mdp.concat(String.valueOf(chara));
        }
         System.out.println("Le mot de passe généré fait " + mdp.length() + " charactères de long");
         System.out.println("Le mot de passe généré est : " + mdp);
        return mdp;
     }

}
