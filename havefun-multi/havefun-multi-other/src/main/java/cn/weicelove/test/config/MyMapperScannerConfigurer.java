package cn.weicelove.test.config;

import cn.weicelove.test.dao.base.MyBaseMapper;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author QIU PANWEI Create in 2019/9/23 16:11
 */
@Configuration
public class MyMapperScannerConfigurer {

    @Bean
    public MapperScannerConfigurer getMyMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setMarkerInterface(MyBaseMapper.class);
        mapperScannerConfigurer.setBasePackage("cn.weicelove.test.dao.mapper");
        return mapperScannerConfigurer;
    }
}
