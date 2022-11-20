
package acme.filter;

import java.util.HashMap;

public class SpamFilter {

	private static HashMap<String, SpamWord>	mapSpamRecords	= new HashMap<String, SpamWord>();
	private static double						spamThreshold;
	private static double						spamBoosterFactor;


	public static void initFilter(final String spamRecords, final double spamThreshold, final double spamBoosterFactor) {
		SpamFilter.spamThreshold = spamThreshold;
		SpamFilter.spamBoosterFactor = spamBoosterFactor;
		SpamFilter.mapSpamRecords = SpamFilter.createMap(spamRecords);
	}

	private static HashMap<String, SpamWord> createMap(final String spamRecords) {
		final HashMap<String, SpamWord> map = new HashMap<String, SpamWord>();
		final String[] wordObjects = spamRecords.split(";");
		for (int i = 0; i < wordObjects.length; i++) {
			final String[] spamObject = wordObjects[i].toLowerCase().replaceAll("[()_]", "").split(",");
			final String name = spamObject[0].trim();
			final Double weight = (("".equals(spamObject[1].trim())) ? SpamFilter.spamBoosterFactor : Double.valueOf(spamObject[1].trim()));
			final String booster = spamObject[2].trim();
			final SpamWord spam = new SpamWord(name, weight, booster);
			map.put(name, spam);
		}
		return map;
	}

	public static boolean isSpam(final String cadena) {
		return SpamFilter.check(cadena, SpamFilter.mapSpamRecords) > SpamFilter.spamThreshold;
	}

	private static double check(final String cadena, final HashMap<String, SpamWord> mapSpamRecords) {
		final String[] term = cadena.split(" ");
		final int limit = term.length - 1;
		double sum = 0.0;
		for (int i = 0; i < term.length; i++) {
			final String current = term[i].toLowerCase().trim();
			if (mapSpamRecords.containsKey(current)) {
				final SpamWord spam = mapSpamRecords.get(current);
				sum += spam.getWeight();
				if (i != 0 && i < limit) {
					final String next = term[i + 1].toLowerCase().trim();
					final String previous = term[i - 1].toLowerCase().trim();
					if (spam.getBoost().equals(previous) || spam.getBoost().equals(next)) {
						sum += SpamFilter.spamBoosterFactor;
					}
				}

			}
		}
		return sum;
	}
}
