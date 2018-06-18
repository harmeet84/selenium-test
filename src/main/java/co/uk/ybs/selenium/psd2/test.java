package co.uk.ybs.selenium.psd2;


public class test {
	
	public static void main(String[] args) {
		
		String url ="https://api-uat.ybs.co.uk/v2/web/option?access_token=4G4EASWoR9aU69P7jTNrYkJP7Si6&refresh_token=pQy2L1iSVG4SmQLpiONZ2Bwd6lV4sEE9";
		
		String token[] = url.split("=", 2);
		String token1[] = token[1].split("&", 2);
		
		System.out.println("values : " +token[1].toString());
		System.out.println("token1 : " +token1[0].toString());
	}
	
}