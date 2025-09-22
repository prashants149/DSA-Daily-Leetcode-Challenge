class MovieRentingSystem {
    private Map<Integer, TreeSet<ShopMovie>> unrented;
    private TreeSet<RentedMovie> rented;
    private Map<Pair, Integer> priceMap;

    public MovieRentingSystem(int n, int[][] entries) {
        unrented = new HashMap<>();
        rented = new TreeSet<>(new RentedMovieComparator());
        priceMap = new HashMap<>();
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(new Pair(shop, movie), price);
            unrented.computeIfAbsent(movie, k -> new TreeSet<>(new ShopMovieComparator()))
                    .add(new ShopMovie(price, shop));
        }
        
    }
    
    public List<Integer> search(int movie) {
        List<Integer> ans = new ArrayList<>();
        if (!unrented.containsKey(movie)) return ans;
        int count = 0;
        for (ShopMovie sm : unrented.get(movie)) {
            ans.add(sm.shop);
            count++;
            if (count >= 5) break;
        }
        return ans;
    }

        
    
    public void rent(int shop, int movie) {
        Pair pm = new Pair(shop, movie);
        Integer price = priceMap.get(pm);
        if (price == null) return;
        TreeSet<ShopMovie> set = unrented.get(movie);
        if (set != null) set.remove(new ShopMovie(price, shop));
        rented.add(new RentedMovie(price, shop, movie));
    }
    
    public void drop(int shop, int movie) {
        Pair pm = new Pair(shop, movie);
        Integer price = priceMap.get(pm);
        if (price == null) return;
        rented.remove(new RentedMovie(price, shop, movie));
        unrented.computeIfAbsent(movie, k -> new TreeSet<>(new ShopMovieComparator()))
                .add(new ShopMovie(price, shop));
    }
        
    
    
    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>();
        int count = 0;
        for (RentedMovie rm : rented) {
            ans.add(Arrays.asList(rm.shop, rm.movie));
            count++;
            if (count >= 5) break;
        }
        return ans;
    }
    private static class ShopMovie {
        int price, shop;
        ShopMovie(int p, int s) { price = p; shop = s; }
        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ShopMovie)) return false;
            ShopMovie other = (ShopMovie) o;
            return price == other.price && shop == other.shop;
        }
        @Override public int hashCode() { return Objects.hash(price, shop);}
    }
    private static class RentedMovie {
        int price, shop, movie;
        RentedMovie(int p, int s, int m) { price = p; shop = s; movie = m; }
        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof RentedMovie)) return false;
            RentedMovie other = (RentedMovie) o;
            return price == other.price && shop == other.shop && movie == other.movie;
        }
        @Override public int hashCode() { return Objects.hash(price, shop, movie); }
    }
    private static class ShopMovieComparator implements Comparator<ShopMovie> {
        @Override public int compare(ShopMovie a, ShopMovie b) {
            if (a.price != b.price) return Integer.compare(a.price, b.price);
            return Integer.compare(a.shop, b.shop);
        }
    }
     private static class RentedMovieComparator implements Comparator<RentedMovie> {
        @Override public int compare(RentedMovie a, RentedMovie b) {
            if (a.price != b.price) return Integer.compare(a.price, b.price);
            if (a.shop != b.shop) return Integer.compare(a.shop, b.shop);
            return Integer.compare(a.movie, b.movie);
        }
    }
    private static class Pair {
        int shop, movie;
        Pair(int s, int m) { shop = s; movie = m; }
        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair other = (Pair) o;
            return shop == other.shop && movie == other.movie;
        }
        @Override public int hashCode() { return Objects.hash(shop, movie); }
    }
}
    