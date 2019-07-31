package itecafe;

import java.util.ArrayList;
import java.util.Scanner;

public class ITECafe {

    public static void main(String[] args) {
        int sum = 0;
        Item hotcoffee = new Item(1, "ホットコーヒー", 280);
        Item tea = new Item(2, "紅茶", 260);
        Item icecoffee = new Item(3, "アイスコーヒー", 200);
        Item icetea = new Item(4, "アイスティー", 260);
        Item shortcake = new Item(5, "ショートケーキ", 400);
        Item cheesecake = new Item(6, "チーズケーキ", 400);
        Item chocolatecake = new Item(7, "チョコレートケーキ", 450);
        Item chocobananaparfait = new Item(8, "チョコバナナパフェ", 390);
        Item strawberryparfait = new Item(9, "イチゴパフェ", 390);
        Item meatpasta = new Item(10, "ミートパスタ", 650);
        Item mixpizza = new Item(11, "ミックスピザ", 700);
        Item croissant = new Item(12, "クロワッサン", 180);
        Item toastsandwich = new Item(13, "トーストサンド", 200);
        Item frenchtoast = new Item(14, "フレンチトースト", 210);

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(hotcoffee);
        itemList.add(tea);
        itemList.add(icecoffee);
        itemList.add(icetea);
        itemList.add(shortcake);
        itemList.add(cheesecake);
        itemList.add(chocolatecake);
        itemList.add(chocobananaparfait);
        itemList.add(strawberryparfait);
        itemList.add(meatpasta);
        itemList.add(mixpizza);
        itemList.add(croissant);
        itemList.add(toastsandwich);
        itemList.add(frenchtoast);

        Scanner scan = new Scanner(System.in);
        System.out.println("■■■ITECafeシステム■■■");
        System.out.println("《メニュー》");
        //メニュー表示
        for (int i = 0; i < itemList.size(); i++) {
            sum *= 1.08;
            System.out.println((i + 1) + "：" + itemList.get(i).getName() + "(税抜き)" + itemList.get(i).getPrice() + "円");
        }
        while (true) {
            try {
                //商品番号入力
                System.out.println("");
                System.out.println("商品番号を入力してください");
                System.out.println("入力が確定したら0を入力してください");
                System.out.print("入力：");
                String num = scan.next();
                int outNum = Integer.parseInt(num);
                //割引チケット処理
                if (outNum == 0) {
                    System.out.println("割引チケットはありますか　(yes)0/(no)1");
                    String waribiki = scan.next();
                    int outwaribiki = Integer.parseInt(waribiki);                    
                    if (outwaribiki == 0) {
                        //チケットあり
                        sum *= 0.75;
                        System.out.println("お会計：" + sum + "円です。(25％割引)");
                        break;                             
                    } else {   
                        //チケットなし
                        System.out.println("お会計：" + sum + "円です。");
                        break;
                    }
                } else {
                    //数量入力・合計金額計算
                    //存在しない商品番号の場合　入力し直し
                    if (outNum <= itemList.size()) {
                        System.out.println(itemList.get(outNum - 1).getName() + ":" + itemList.get(outNum - 1).getPrice() + "円");
                        System.out.print("数量を入力してください：");
                        Scanner scan1 = new Scanner(System.in);
                        String num1 = scan.next();
                        int outNum1 = Integer.parseInt(num1);
                        sum += itemList.get(outNum - 1).getPrice() * outNum1;
                        sum *= 1.08;
                        System.out.println("合計金額(税込み)" + "：" + sum + "円");
                    } else {
                        System.out.println("存在しない商品番号です。");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("【入力エラー：数値を入力してください】");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("【入力エラー：やり直してください】");
            }
        }
        while (true) {
            try {
                //会計処理
                System.out.print("預かり金額を入力してください：");
                String azukari = scan.next();
                int outAzukari = Integer.parseInt(azukari);
                outAzukari -= sum;
                //金額が足りない場合
                if (outAzukari < 0) {
                    System.out.println("【金額が足りません。入力し直してください】");
                } else {
                    //お釣り処理
                    if (outAzukari == 0) {
                        System.out.println("お釣り：ありません");
                        System.out.println("ありがとうございました。");
                        break;
                    } else {
                        System.out.println("お釣り：" + outAzukari + "円です");
                        System.out.println("ありがとうございました。");
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("【入力エラー：数値を入力してください】");
            }
        }

    }
}
