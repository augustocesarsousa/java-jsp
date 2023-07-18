package utils;

public class DefaultUserImage {

	public static String getImage() {
		return "data:image/jpeg;base64,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";
	}
}