package com.leyou.item.controller;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.bo.SpuBo;
import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.Spu;
import com.leyou.item.pojo.SpuDetail;
import com.leyou.item.pojo.Stock;
import com.leyou.item.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.Date;
import java.util.List;

@Controller
public class GoodsControlller {

    @Autowired
    private GoodsService goodsService;


    /**
     * 根据条件分页查询spu
     * @param key
     * @param saleable
     * @param page
     * @param rows
     * @return
     */
    @GetMapping("spu/page")
    public ResponseEntity<PageResult<SpuBo>> querySpuBypage(
            @RequestParam(value = "key",required = false)String key,
            @RequestParam(value = "saleable",required = false)Boolean saleable,
            @RequestParam(value = "page",defaultValue = "1")Integer page,
            @RequestParam(value = "rows",defaultValue = "5")Integer rows
    ){
        PageResult<SpuBo> result = this.goodsService.querySpuByPage(key,saleable,page,rows);
        if (result ==null|| CollectionUtils.isEmpty(result.getItems())){//本身为空或内容为空
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 新增商品
     * @param spuBo
     */
    @PostMapping("goods")
    public ResponseEntity<Void> saveGoods(@RequestBody SpuBo spuBo){
        this.goodsService.saveGoods(spuBo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 更新商品信息
     * @param spuBo
     * @return
     */
    @PutMapping("goods")
    public ResponseEntity<Void> updateGoods(@RequestBody SpuBo spuBo){
        this.goodsService.updateGoods(spuBo);
        return ResponseEntity.noContent().build();//更新和删除成功 用204状态码
    }



    /**
     * 根据spuId查询spuDetail
     * @param spuid
     * @return
     */
    @GetMapping("spu/detail/{spuId}")
    public ResponseEntity<SpuDetail> querySpuDetailBySpuId(@PathVariable("spuId")Long spuid){
        SpuDetail spuDetail = this.goodsService.querySpuDetailBySpuId(spuid);
        if(spuDetail==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(spuDetail);
    }


    /**
     * 根据spuId查询sku集合
     * @param spuId
     * @return
     */
    @GetMapping("sku/list")
    public  ResponseEntity<List<Sku>> querySkuBySpuId(@RequestParam("spuId")Long spuId){
        List<Sku> skus = this.goodsService.querySkuBySpuId(spuId);
        if(CollectionUtils.isEmpty(skus)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(skus);
    }


    @GetMapping("{id}")
    public ResponseEntity<Spu> querySpuById(@PathVariable("id")Long id){
        Spu spu = this.goodsService.querySpuById(id);

        if(spu==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(spu);
    }


    @GetMapping("sku/{skuId}")
    public ResponseEntity<Sku> querySkuBySkuId(@PathVariable("skuId")Long skuId){
        Sku sku = this.goodsService.querySkuBySkuId(skuId);

        if(sku==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sku);
    }





}
