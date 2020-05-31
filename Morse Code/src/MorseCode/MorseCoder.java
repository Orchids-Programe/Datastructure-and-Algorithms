package MorseCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCoder implements MorseCodeInterface{
	
	private MorseNode root;
	
	public MorseCoder() {
		root = new MorseNode();
		readInfo();
	}
	
	private void readInfo() {
		Scanner input = null;
		try {
			input = new Scanner(new File("E:\\Java Code\\Morse Code\\src\\MorseCode\\encodings.txt"));
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("File not found!");
		}
		
		while (input.hasNextLine()) {
			String data = input.nextLine().trim(); 		//loại bỏ space ở đầu và cuối
			if(data.length() > 0) {
				add(data.substring(1).trim(), data.charAt(0));		//substring trả về chuỗi con của chuỗi đ
			}
		}
		input.close();
	}
	
	public void add(String mcode, char ltr) {
		MorseNode current = root;
		String signal = " ";
		
		for(int i = 0; i < mcode.length(); i++) {
			signal = mcode.substring(i, i + 1);
			if(signal.equals(".")) {
				if(current.getLeft() != null) {
					current = current.getLeft();
				}
				else {
					current.setLeft(new MorseNode());
					current = current.getLeft();
				}
			}
			else {
				if(current.getRight() != null) {
					current = current.getRight();
				}
				else {
					current.setRight(new MorseNode());
					current = current.getRight();
				}
			}
		}
		current.setLetter(ltr);
	}
	
	public void inOrderPrint() {
		MorseNode current = root;
		printInOrder(current);
	}
	
	private void printInOrder(MorseNode current) {
		if(current != null) {
			printInOrder(current.getLeft());
			System.out.println(current.getLetter());
			printInOrder(current.getRight());
		}
	}
	
	public String decode(String str) {
		String signal = "";
		StringBuffer result = new StringBuffer("");
		MorseNode current = root;
		
		for(int i = 0; i < str.length(); i++) {
			signal = str.substring(i, i+1);
			if(signal.equals(".")) {
				if(current.getLeft() != null) {
					current = current.getLeft();
				}
				else {
					current.setLeft(new MorseNode());
					current = current.getLeft();
				}
			}
			else if (signal.equals("-")) {
				if(current.getRight() != null) {
					current = current.getRight();
				}
				else {
					current.setRight(new MorseNode());;
					current = current.getRight();
				}
			}
			else {
				result = result.append(current.getLetter());
				current = root;
			}
		}
		result = result.append(current.getLetter());
		return result.toString();
	}
	
	public String encode(String str) {
		MorseNode current = root;
		String result = "";
		String s = "";
		char ltr;
		
		for(int i = 0; i < str.length(); i++) {
			ltr = str.charAt(i);
			result = searchTree(current, ltr, s);
		}
		return result;
	}
	
	
	
	public String searchTree(MorseNode current, char ltr, String s) {
		char temp = current.getLetter();
		
		if(current.getLetter() == ltr) {
			return s;
		}
		else {
			if(current.getLeft() != null) {
				return searchTree(current.getLeft(), ltr, s + ".");
			}
			if(current.getRight() != null) {
				return searchTree(current.getRight(), ltr, s + "-");
			}
			return s;
		}
	}
	
//	static String morseEncode(char x) {
//		switch(x) {
//		case 'a': 
//            return ".-"; 
//        case 'b': 
//            return "-..."; 
//        case 'c': 
//            return "-.-."; 
//        case 'd': 
//            return "-.."; 
//        case 'e': 
//            return "."; 
//        case 'f': 
//            return "..-."; 
//        case 'g': 
//            return "--."; 
//        case 'h': 
//            return "...."; 
//        case 'i': 
//            return ".."; 
//        case 'j': 
//            return ".---"; 
//        case 'k': 
//            return "-.-"; 
//        case 'l': 
//            return ".-.."; 
//        case 'm': 
//            return "--"; 
//        case 'n': 
//            return "-."; 
//        case 'o': 
//            return "---"; 
//        case 'p': 
//            return ".--."; 
//        case 'q': 
//            return "--.-"; 
//        case 'r': 
//            return ".-."; 
//        case 's': 
//            return "..."; 
//        case 't': 
//            return "-"; 
//        case 'u': 
//            return "..-"; 
//        case 'v': 
//            return "...-"; 
//        case 'w': 
//            return ".--"; 
//        case 'x': 
//            return "-..-"; 
//        case 'y': 
//            return "-.--"; 
//        // for space 
//        case 'z': 
//            return "--.."; 
//    } 
//    return ""; 
//		
//	}
//	
//	public String encode(String s) {
//		for(int i = 0; i < s.length(); i++) {
//			System.out.print(morseEncode(s.charAt(i)));
////			System.out.println();
//		}
//		return s;
//	}

}
