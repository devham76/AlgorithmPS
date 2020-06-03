package AdapterPatteren;

public class FormatAdapter implements MediaPlayer{

	private MediaPackage media;
	
	public FormatAdapter(MediaPackage m) {
		media = m;
	}
	@Override
	public void play(String filename) {
		System.out.println("using adapter --> ");
		media.playFile(filename);
		
	}

	
}
