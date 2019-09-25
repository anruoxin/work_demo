package cn.weicelove.test.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author QIU PANWEI Create in 2019/9/23 16:11
 */
@Configuration
public class MyMapperScannerConfigurer {

    @Bean
    public MapperScannerConfigurer getMyMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setMarkerInterface(Mapper.class);
        mapperScannerConfigurer.setBasePackage("cn.weicelove.test.dao.mapper");
        return mapperScannerConfigurer;
    }
}
