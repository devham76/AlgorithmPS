package AdapterPatteren;

public class MKV implements MediaPackage {

	@Override
	public void playFile(String filename) {
		
		System.out.println("playing mkv file "+filename);
			
	}
	
}
