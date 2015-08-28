package com.elrain.whattocook.service;

import com.elrain.whattocook.webutil.response.Urls;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elrain on 13.08.15.
 */
@Path("/rostik")
public class StringsForRostik {

    @GET
    @Path("/get")
    public Response getUrls(){
        List<Urls> urls = new ArrayList<Urls>();
        urls.add(new Urls("http://ww1.prweb.com/prfiles/2014/04/10/11752526/gI_134971_best-image-web-hosting.png"));
        urls.add(new Urls("http://www.keenthemes.com/preview/metronic/theme/assets/global/plugins/jcrop/demos/demo_files/image2.jpg"));
        urls.add(new Urls("http://www.bearingscity.am/gallery/img/demopage/image-3.jpg"));
        urls.add(new Urls("http://www.thinkstockphotos.co.uk/CMS/StaticContent/Hero/TS_AnonHP_462882495_01.jpg"));
        urls.add(new Urls("http://www.wired.com/wp-content/uploads/2014/12/9-credit-1.jpg"));
        urls.add(new Urls("http://www.wired.com/images_blogs/rawfile/2013/11/offset_WaterHouseMarineImages_62652-2-660x4401.jpg"));
        urls.add(new Urls("http://globe-views.com/dcim/dreams/image/image-03.jpg"));
        urls.add(new Urls("http://wowslider.com/sliders/demo-85/data1/images/southtyrol350698.jpg"));
        urls.add(new Urls("http://www.babelio.com/couv/CVT_Arree-sur-image_2119.jpeg"));
        urls.add(new Urls("http://www.lifeofpiepizza.com/wp-content/uploads/2013/10/3707991.jpg"));
        urls.add(new Urls("http://brogdonproperties.com/wp-content/uploads/2014/12/rustic-dark-wood-background-brandon-bourdages.jpg"));
        urls.add(new Urls("http://static.tumblr.com/fe753f148774dd70850d1339ba58d226/an3h16g/bmJnexwbw/tumblr_static_1nkrjihyyi804cccwkwgggkks.jpg"));
        urls.add(new Urls("https://static.pexels.com/photos/1486/wood-pattern-ground-parquet-floor.jpg"));
        return Response.ok(urls, MediaType.APPLICATION_JSON).build();
    }
}
