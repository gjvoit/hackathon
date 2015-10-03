package hackathonGroup.hackathonID.helperFunctions;

public class BrowserInfo {
	private String browserName;
	private String versionNumber;
	private String browserShorthand;
	
	public BrowserInfo(String browserName, String versionNumber) {
        this.browserName = browserName;
        this.versionNumber = versionNumber;
    }
	
	public String getBrowserName() {
		return browserName;
	}
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	public String getPlatformName() {
		return "WINDOWS";
	}
	
	public String getVersionNumber() {
		return versionNumber;
	}
	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}
	public String getBaseURL() {
		return "http://54.173.118.20:9000/";
	}
	
	public String getBrowserShorthand(){
		browserName = getBrowserName();
		versionNumber = getVersionNumber();
        String browserShorthand = "";
        if (browserName.contains("Chrome")){
        	browserShorthand = "Chrome";
        } else if (browserName.contains("Firefox")){
        	browserShorthand = "Firefox";
        } else if (browserName.contains("internet explorer") && versionNumber.contains("8")){
        	browserShorthand = "IE 8";
        } else if (browserName.contains("internet explorer") && versionNumber.contains("9")){
        	browserShorthand = "IE 9";
        } else if (browserName.contains("internet explorer") && versionNumber.contains("10")){
        	browserShorthand = "IE 10";
        } else if (browserName.contains("internet explorer") && versionNumber.contains("11")){
        	browserShorthand = "IE 11";
        }
        
        return browserShorthand;
	}
	
	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String browserShorthand = getBrowserShorthand();
        
        builder.append(" " + browserShorthand + " ");
        return builder.toString();
    }
	

}
