package interview;

import java.util.Arrays;

public class BestTimeToSellStocks {

	public static void main(String[] args) {

		int[] pirces = { 7, 7, 2, 2, 1, 5, 3, 6, 4 };

		int maxProf = maxProfitOnMultipleSales(pirces);
		System.out.println(maxProf);

		System.out.println(maxProfitProfitFromStcokSale(pirces));
	}

	private static int maxProfitOnMultipleSales(int[] prices) {
		int totalProfit = 0;
		if (prices.length < 2) {
			return 0;
		}
		int minValue = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < prices[i - 1]) {
				totalProfit += prices[i - 1] - minValue;
				minValue = prices[i];
			}
		}
		totalProfit += prices[prices.length - 1] - minValue;
		return totalProfit;
	}

	private static int maxProfitProfitFromStcokSale(int[] p) {
		int totalProfit = 0;
		int[] profit = new int[p.length / 2];
		int i = 1, j = 0;
		int minPrice = p[i];

		while (i < p.length) {
			if (p[i] < p[i - 1]) {
				profit[j++] = p[i - 1] - minPrice;
				minPrice = p[i];

			}
			i++;

		}

		System.out.println(Arrays.toString(profit));

		for (int n : profit) {
			totalProfit += n;
		}

		return totalProfit;
	}

}
