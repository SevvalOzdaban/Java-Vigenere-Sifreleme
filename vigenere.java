import java.util.Locale;
public class Odev1{

    public String encrypt(String originalText, String key)
    {
        String alfabe = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        originalText = toUpperString(originalText);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < originalText.length(); i++) {
            int sifrelenecekKarakter = alfabe.indexOf(originalText.charAt(i));
            //Alfabenin indexi 0'dan başladığı için +1 ekleme yapıldı 
            int sifreleyecekAnahtarHarfi = alfabe.indexOf(key.charAt(i % key.length())) + 1;
            int harfSonuc = (sifrelenecekKarakter + sifreleyecekAnahtarHarfi) % alfabe.length();
             str.append(alfabe.charAt(harfSonuc));
        }
        return str.toString();
    }


    public String toUpperString(String text)
    {
        //Harfleri çevirirken ingiliz alfabesini baz alması için locale.ENGLISH kullanıldı
        text = text.toUpperCase(Locale.ENGLISH);
        return text;
    }
    
   public String decrypt(String encryptedText, String key){
        String alfabe = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            encryptedText = toUpperString(encryptedText);
            int sifrelenmisKarakter = alfabe.indexOf(encryptedText.charAt(i));
            int cozecekAnahtarHarfi = alfabe.indexOf(key.charAt(i % key.length())) + 1;
            int harfSonuc = (sifrelenmisKarakter - cozecekAnahtarHarfi) % alfabe.length();
            //index'in sıfırdan küçük olma ihtimali düşünülerek alfabenin boyutu eklendi
            if (harfSonuc < 0) {
                harfSonuc += alfabe.length();
            }
            str.append(alfabe.charAt(harfSonuc));
        }
        return str.toString();
   }

}