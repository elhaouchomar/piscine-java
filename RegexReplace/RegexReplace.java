public class RegexReplace {
    
    public static String removeUnits(String s) {
        if (s == null) {
            return null;
        }
        String result = s.replaceAll("(\\d)(cm|€)(?= |$)", "$1");
        return result;
    }
    
    public static String obfuscateEmail(String s) {
        if (s == null) {
            return null;
        }
        
        String[] parts = s.split("@");
        if (parts.length != 2) {
            return s;
        }
        
        String username = parts[0];
        String domain = parts[1];
        
        String obfuscatedUsername = obfuscateUsername(username);
        String obfuscatedDomain = obfuscateDomain(domain);
        
        return obfuscatedUsername + "@" + obfuscatedDomain;
    }
    
    private static String obfuscateUsername(String username) {
        if (username.contains("-") || username.contains(".") || username.contains("_")) {
            int lastSeparatorIndex = Math.max(
                Math.max(username.lastIndexOf("-"), username.lastIndexOf(".")),
                username.lastIndexOf("_")
            );
            String beforeSeparator = username.substring(0, lastSeparatorIndex + 1);
            String afterSeparator = username.substring(lastSeparatorIndex + 1);
            return beforeSeparator + "*".repeat(afterSeparator.length());
        } else if (username.length() > 3) {
            return username.substring(0, username.length() - 1) + "*";
        }
        return username;
    }
    
    private static String obfuscateDomain(String domain) {
        String[] domainParts = domain.split("\\.");
        
        if (domainParts.length == 3) {
            String thirdLevel = domainParts[0];
            String secondLevel = domainParts[1];
            String topLevel = domainParts[2];
            return "*".repeat(thirdLevel.length()) + "." + secondLevel + "." + "*".repeat(topLevel.length());
        } else if (domainParts.length == 2) {
            String secondLevel = domainParts[0];
            String topLevel = domainParts[1];
            
            if (topLevel.equals("com") || topLevel.equals("org") || topLevel.equals("net")) {
                return "*".repeat(secondLevel.length()) + "." + topLevel;
            } else {
                return "*".repeat(secondLevel.length()) + "." + "*".repeat(topLevel.length());
            }
        }
        
        return domain;
    }
}