package common;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Pet;
import entities.items.*;
import entities.items.consumables.Drug;
import entities.items.consumables.Food;
import entities.items.consumables.Shampoo;
import entities.templates.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.apache.commons.collections.CollectionUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Zhou Guanliang
 * @since 2017/8/9
 */
public class Utils {
    public static void init(String configPath) {
        String content = read(configPath);
        initAll(JSONObject.fromObject(content));
    }

    public static void initAll(JSONObject json) {
        initField(json, Constants.KEY_PET, Pet.class);
        initField(json, Constants.KEY_MONEY, Integer.class);

        initListField(json, Constants.KEY_FOODS, Food.class);
        initListField(json, Constants.KEY_BOWLS, Bowl.class);
        initListField(json, Constants.KEY_AUTO_FEEDERS, AutoFeeder.class);
        initListField(json, Constants.KEY_WATER_CLEANERS, WaterCleaner.class);
        initListField(json, Constants.KEY_SHAMPOOS, Shampoo.class);
        initListField(json, Constants.KEY_BATH_BAGS, BathBag.class);
        initListField(json, Constants.KEY_DRYERS, Dryer.class);
        initListField(json, Constants.KEY_HOUSES, House.class);
        initListField(json, Constants.KEY_TOYS, Toy.class);
        initListField(json, Constants.KEY_DRUGS, Drug.class);

        initListField(json, Constants.KEY_FOOD_TEMPLATES, FoodTemplate.class);
        initListField(json, Constants.KEY_BOWL_TEMPLATES, BowlTemplate.class);
        initListField(json, Constants.KEY_AUTO_FEEDER_TEMPLATES, AutoFeederTemplate.class);
        initListField(json, Constants.KEY_WATER_CLEANER_TEMPLATES, WaterCleanerTemplate.class);
        initListField(json, Constants.KEY_SHAMPOO_TEMPLATES, ShampooTemplate.class);
        initListField(json, Constants.KEY_BATH_BAG_TEMPLATES, BathBagTemplate.class);
        initListField(json, Constants.KEY_DRYER_TEMPLATES, DryerTemplate.class);
        initListField(json, Constants.KEY_HOUSE_TEMPLATES, HouseTemplate.class);
        initListField(json, Constants.KEY_TOY_TEMPLATES, ToyTemplate.class);
        initListField(json, Constants.KEY_DRUG_TEMPLATES, DrugTemplate.class);
    }

    public static <T> void initField(JSONObject json, String key, Class<T> clazz) {
        String value = JSONUtils.valueToString(json.get(key));
        Cache.put(key, fromJson(value, clazz));
    }

    public static <T> void initListField(JSONObject json, String key, Class<T> clazz) {
        JSONArray array = json.optJSONArray(key);
        if (!CollectionUtils.isEmpty(array)) {
            List<T> list = new ArrayList<>();
            array.forEach(e -> list.add(fromJson(e.toString(), clazz)));
            Cache.put(key, list);
        }
    }

    public static String toJson(Object o) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String toPrettyJson(Object o) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String read(String filePath) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(filePath).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\r\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void write(String filePath, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(filePath).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean tossCoin(int possibility) {
        if (possibility >= 100) {
            return true;
        }
        if (possibility <= 0) {
            return false;
        }
        int result = getRandomNumber(0, 100);
        return result < possibility;
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static int safeAdd(int value, int offset) {
        value += offset;
        return value > Constants.MAX_VALUE ? Constants.MAX_VALUE : value;
    }

    public static int safeSub(int value, int offset) {
        value -= offset;
        return value < Constants.MIN_VALUE ? Constants.MIN_VALUE : value;
    }
}