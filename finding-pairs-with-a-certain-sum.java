class FindSumPairs {
    private int[] nums1; // 🏦 Warehouse 1: An array holding the items in the first warehouse.
    private int[] nums2; // 🏦 Warehouse 2: An array holding the *prices* of items in the second warehouse.
    private Map<Integer, Integer> counts; // 📝 A notebook (HashMap) to quickly look up how many times each price appears in warehouse 2. Think of it like a cheat sheet!

    public FindSumPairs(int[] nums1, int[] nums2) { // 👷 Constructor: This is like the construction crew setting up the warehouses.
        this.nums1 = nums1; // 🚚 Unloading items into Warehouse 1.
        this.nums2 = nums2; // 💰 Unloading price tags into Warehouse 2.
        this.counts = new HashMap<>(); // 📒 Creating our cheat sheet (notebook).

        for (int num : nums2) { // 🚶 Walking through each price in Warehouse 2.
            counts.put(num, counts.getOrDefault(num, 0) + 1); // ✍️ Writing down how many times each price appears on our cheat sheet.
                                                                // Like counting how many items have the same price.
        }
    }

    public void add(int index, int val) { // ➕ Adding price to a certain item. This is like adjusting the price in our inventory system!
        int oldValue = nums2[index]; // 🏷️ Remembering the old price of the item.
        nums2[index] += val; // 📈 Actually changing the price in Warehouse 2 (in our array).
        int newValue = nums2[index]; // 🏷️ Remembering the new price

        // Update the counts map

        counts.put(oldValue, counts.get(oldValue) - 1); // 📉 Reduce count of old price. Think of it like deleting the count from the inventory

        // if price doesnt exist anymore, take it out
        if (counts.get(oldValue) == 0) { // 🔍
            counts.remove(oldValue); // 🗑️
        }

        counts.put(newValue, counts.getOrDefault(newValue, 0) + 1); // 📈 Add new price to total counts. Think of it like creating count for inventory
    }

    public int count(int tot) { // 🎯 Finding pairs of items that sum up to a total price 'tot'.
        int totalPairs = 0; // 📊 Starting our count of pairs from zero.
        for (int i = 0; i < nums1.length; i++) { // 🚶 Walking through each item (price) in Warehouse 1.
            int target = tot - nums1[i]; // 🎯 Figuring out what price we need from Warehouse 2 to reach our target 'tot'.
            totalPairs += counts.getOrDefault(target, 0); // 📒 Looking up in our cheat sheet how many items in Warehouse 2 have the price we need!
        }
        return totalPairs; // 🎉 Returning the total number of pairs we found.
    }
}
