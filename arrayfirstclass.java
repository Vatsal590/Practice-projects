 import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class arrayfirstclass {
   

    public static void main(String[] args) {
        // 1. Sample data: countries with current oil barrel prices (fictional values)
        String[] countries = {"Saudi Arabia", "USA", "UK", "Norway", "Canada"};
        double[] pricesUSD = {70.5, 68.2, 72.0, 75.3, 73.4}; // Prices in USD per barrel

        // 2. Find the highest price and its index
        double maxPrice = pricesUSD[0];
        int maxIndex = 0;
        for (int i = 1; i < pricesUSD.length; i++) {
            if (pricesUSD[i] > maxPrice) {
                maxPrice = pricesUSD[i];
                maxIndex = i;
            }
        }

        String country = countries[maxIndex];

        // 3. Prepare currency formatters: local, EUR, USD
        Currency localCurrency = null;
        Locale localLocale = Locale.US; // Default: US
        switch (country) {
            case "UK":
                localLocale = Locale.UK;
                break;
            case "Norway":
                localLocale = new Locale("no", "NO");
                break;
            case "Canada":
                localLocale = Locale.CANADA;
                break;
            case "Saudi Arabia":
                localLocale = new Locale("ar", "SA");
                break;
            case "USA":
            default:
                localLocale = Locale.US;
                break;
        }
        NumberFormat localFormat = NumberFormat.getCurrencyInstance(localLocale);
        localFormat.setCurrency(Currency.getInstance(localLocale));

        // Euro formatter (German locale for example)
        NumberFormat euroFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        euroFormat.setCurrency(Currency.getInstance("EUR"));

        // USD formatter
        NumberFormat usdFormat = NumberFormat.getCurrencyInstance(Locale.US);
        usdFormat.setCurrency(Currency.getInstance("USD"));

        // 4. Print results
        System.out.println("Global Oil Price Analysis:");
        System.out.println("---------------------------");
        System.out.println("Highest oil price:");
        System.out.println("Country: " + country);
        System.out.println("Price in local currency: " + localFormat.format(maxPrice));
        System.out.println("Price in Euros:           " + euroFormat.format(maxPrice));
        System.out.println("Price in US Dollars:      " + usdFormat.format(maxPrice));
    }
}



