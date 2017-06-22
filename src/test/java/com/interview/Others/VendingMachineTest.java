package com.interview.Others;

import com.interview.vendingMachine.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Mike on 2017-04-14.
 */
public class VendingMachineTest {

    VendingMachine vm;

    @Before
    public void setVm(){
        this.vm=new VendingMachineImpl();
    }

    @After
    public void destroyVm(){
        this.vm=null;
    }

    @Test
    public void testVm(){
        assertThat(vm).isNotNull();
    }

    @Test
    public void selectItemAndGetPriceMethodTest(){

        Item item = Item.COKE;

        assertThat(vm.selectItemAndGetPrice(item)).isEqualTo(Item.COKE.getPrice());

    }

    @Test
    public void coinInInvetoryTest(){

        assertThat(vm.getCoinInInventory()).isNotNull();
        assertThat(vm.getCoinInInventory().hasItem(Coin.DWADZIESCIAGROSZY)).isEqualTo(true);
        assertThat(vm.getCoinInInventory().getQuantity(Coin.DWADZIESCIAGROSZY)).isEqualTo(3);

    }

    @Test
    public void collectItemAndChangeTest(){

        Item item = Item.PEPSI;

        assertThat(vm.selectItemAndGetPrice(item)).isEqualTo(3.5);

        vm.insertCoin(Coin.DWAZLOTE);
        vm.insertCoin(Coin.ZLOTOWKA);
        vm.insertCoin(Coin.PIEDZIESIATGROSZY);

        Bucket<Item,List<Coin>> bucket = vm.collectItemAndChange();

        assertThat(bucket.getItem()).isEqualTo(item);
        assertThat(bucket.getCoins()).isEmpty();

    }

    @Test
    public void collectItemAndChangeTestVol2(){

        Item item = Item.CHIPS;

        assertThat(vm.selectItemAndGetPrice(item)).isEqualTo(4.0);

        vm.insertCoin(Coin.PIECZLOTY);


        Bucket<Item,List<Coin>> bucket = vm.collectItemAndChange();

        assertThat(bucket.getItem()).isEqualTo(item);
        assertThat(bucket.getCoins()).contains(Coin.ZLOTOWKA);

    }

    @Test
    public void collectItemAndChangeTestVol3(){

        Item item = Item.CHIPS;

        assertThat(vm.selectItemAndGetPrice(item)).isEqualTo(4.0);

        vm.insertCoin(Coin.PIECZLOTY);
        vm.insertCoin(Coin.DWADZIESCIAGROSZY);


        Bucket<Item,List<Coin>> bucket = vm.collectItemAndChange();

        assertThat(bucket.getItem()).isEqualTo(item);
        assertThat(bucket.getCoins()).contains(Coin.ZLOTOWKA);
        assertThat(bucket.getCoins()).contains(Coin.DWADZIESCIAGROSZY);

    }

    @Test
    public void refundTest(){

        vm.insertCoin(Coin.PIEDZIESIATGROSZY);

        List<Coin> refunded = vm.refund();

        assertThat(refunded).contains(Coin.PIEDZIESIATGROSZY);

    }

    @Test(expected = NotFullyPaidException.class)
    public void notFullyPaidExceptionTest(){

        vm.selectItemAndGetPrice(Item.CHIPS);

        vm.insertCoin(Coin.DWAZLOTE);

        vm.collectItemAndChange();

    }

    @Test(expected = SoldOutException.class)
    public void soldOutExceptionTest(){
        for(int i=0;i<4;i++) {
            vm.selectItemAndGetPrice(Item.CHIPS);
            vm.insertCoin(Coin.PIECZLOTY);
            vm.collectItemAndChange();
        }

    }

    @Test(expected = NotSufficientChangeException.class)
    public void notSuffiecientChangeExceptionTest(){

        for(int i=0;i<3;i++) {
            vm.selectItemAndGetPrice(Item.PEPSI);
            vm.insertCoin(Coin.DWAZLOTE);
            vm.insertCoin(Coin.DWAZLOTE);
            vm.collectItemAndChange();
        }

        vm.selectItemAndGetPrice(Item.COKE);
        vm.insertCoin(Coin.DWAZLOTE);
        vm.insertCoin(Coin.ZLOTOWKA);
        vm.collectItemAndChange();

    }


}
