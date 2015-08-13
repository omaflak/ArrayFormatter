

public class ArrayFormatter {
	
	public String[] getCredit(String message, String character, int width, int numberOfLines, int space){
		String str[] = new String[numberOfLines];
		for (int i=0 ; i<str.length ; i++){
			if(i==str.length/2){
				str[i]=getMessageLine(message, character, width, space);
			}
			else{
				str[i]=getCar(character, width);
			}
		}
		return str;
	}
	
	private String getCar(String s, int len){
		String car = s;
		for(int i=0 ; i<len ; i++)
			s+=car;
		return s;
	}
	
	private String getMessageLine(String message, String character, int width, int spaceBetweenMessage){
		String s="";
		int mid = (width-message.length())/2-spaceBetweenMessage;
		int comp;
		boolean first=false;
		for (int i=0 ; i<width ; i++){
			if(!first)
				comp=i;
			else
				comp=width-i;
			if(comp!=mid){
				s+=character;
			}
			else{
				int in = s.length();
				s+=getCar(" ", spaceBetweenMessage);
				s+=message;
				s+=getCar(" ", spaceBetweenMessage);
				in=s.length()-in;
				i+=in-2;
			}
		}
		return s;
	}
	
	private int getLongest(String[] str){
		int len=0;
		for (String s : str){
			if(s.length()>len)
				len=s.length();
		}
		return len;
	}
	
	private String getSpace(int from, int to, int total){
		String s="";
		for (int i=0 ; i<to-from+total ; i++){
			s+=" ";
		}
		return s;
	}
	
	public int getArrayLen(int spaceBetweenArrays, String[] ...arrays){
		int len=0, index=0;
		String[] last = arrays[arrays.length-1];
		for (int i=0 ; i<last.length ; i++){
			if(last[i].length()>len){
				len = last[i].length();
				index=i;
			}
		}
		
		int[] spaces = new int[arrays.length-1];
		for (int i=0 ; i<arrays.length-1 ; i++){
			String space = getSpace(arrays[i][index].length(), getLongest(arrays[i]), spaceBetweenArrays);
			spaces[i] = space.length();
		}
		
		int finalLen=0;
		
		for (int i=0 ; i<arrays.length ; i++)
			finalLen+=arrays[i][index].length();
		
		for (int i=0 ; i<spaces.length; i++)
			finalLen+=spaces[i];
		
		if(finalLen%2!=0)
			finalLen++;
		return finalLen;
	}
	
	public String[] getCleanArray(int spaceBetweenArrays, String[] ...arrays){
		String[] clean = new String[arrays[0].length];
		String s="";
		for (int i=0 ; i<arrays[0].length ; i++){
			for (int j=0 ; j<arrays.length ; j++){
				s+=arrays[j][i];
				if(j!=arrays.length-1)
					s+=getSpace(arrays[j][i].length(), getLongest(arrays[j]), spaceBetweenArrays);
			}
			clean[i]=s;
			s="";
		}
		return clean;
	}
	
}
