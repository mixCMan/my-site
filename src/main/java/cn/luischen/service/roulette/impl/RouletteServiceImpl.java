package cn.luischen.service.roulette.impl;

import cn.luischen.service.roulette.RouletteService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by chenyuanmeng on 2020/08/04.
 */
@Service
public class RouletteServiceImpl implements RouletteService {
    private static final Logger logger = LoggerFactory.getLogger(RouletteServiceImpl.class);

    @Override
    public List<Integer> bigHappy() {
        List<Integer> red = new ArrayList<>();
        List<Integer> blue = new ArrayList<>();
        List<Integer> last = new ArrayList<>();
        List<Integer> rand = new ArrayList<>();

        for(int i =1; i<=35;i++){
            red.add(i);
        }
        for(int j = 1; j <= 12; j++){
            blue.add(j);
        }

        for(int l=0;l<5;l++){
            Integer random = getRandom(rand, red.size());
            last.add(red.get(random));
        }

        for(int f=last.size()-1;f>=0;f--){
            for(int s=0;s<f;s++){
                if(last.get(s)>last.get(s+1)){
                    int b = last.get(s+1);
                    last.set(s+1,last.get(s));
                    last.set(s,b);
                }
            }
        }
        for(int l=0;l<2;l++){
            Integer random = getRandom(rand, blue.size());
            last.add(blue.get(random));
        }
        logger.info("last-list:{}",JSON.toJSONString(last));
        return last;
    }

    @Override
    public List<Integer> doubleColor() {
        List<Integer> red = new ArrayList<>();
        List<Integer> blue = new ArrayList<>();
        List<Integer> last = new ArrayList<>();
        List<Integer> rand = new ArrayList<>();

        for(int i =1; i<=33;i++){
            red.add(i);
        }
        for(int j = 1; j <= 16; j++){
            blue.add(j);
        }

        for(int l=0;l<6;l++){
            Integer random = getRandom(rand, red.size());
            last.add(red.get(random));
        }

        for(int f=last.size()-1;f>=0;f--){
            for(int s=0;s<f;s++){
                if(last.get(s)>last.get(s+1)){
                    int b = last.get(s+1);
                    last.set(s+1,last.get(s));
                    last.set(s,b);
                }
            }
        }
        Integer random = getRandom(rand, blue.size());
        last.add(blue.get(random));
        logger.info("last-list:{}",JSON.toJSONString(last));
        return last;
    }

    /**
     * 根据传入的size获取随机值
     * @param rand 保存的list
     * @param size 随机数的范围
     * @return
     */
    private  Integer getRandom(List<Integer> rand,int size){
        int i = new Random().nextInt(size);
        System.out.println("rendom count:"+ i);
        if(rand.contains(i)){
            return getRandom(rand,size);
        }
        rand.add(i);
        return  i;

    }


}
