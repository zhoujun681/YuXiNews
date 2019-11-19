package com.bbapps.yuxinews.domain;

import java.util.List;

public class TabDetailPagerBean {

    /**
     * data : {"countcommenturl":"/client/content/countComment/",
     * "more":"/static/api/news/10007/list_2.json","news":[{"comment":true,
     * "commentlist":"/static/api/news/10007/61/147261/comment_1.json",
     * "commenturl":"/client/user/newComment/147261","id":147261,
     * "listimage":"/static/images/2015/10/19/34/1987564164OD60.jpg","pubdate":"2015-10-19
     * 07:44","title":"河北\u201c大头娃娃\u201d出生即患脑积水 与母蜗居30年","type":"news",
     * "url":"/static/html/2015/10/19/75486F51496C197A6F227844.html"},{"comment":true,
     * "commentlist":"/static/api/news/10007/51/147251/comment_1.json",
     * "commenturl":"/client/user/newComment/147251","id":147251,
     * "listimage":"/static/images/2015/10/19/35/1987564164595O.jpg","pubdate":"2015-10-19
     * 07:17","title":"香山公园发布四条赏红路线","type":"news",
     * "url":"/static/html/2015/10/19/724F6E50486D1D7E69277F43.html"},{"comment":true,
     * "commentlist":"/static/api/news/10007/49/147249/comment_1.json",
     * "commenturl":"/client/user/newComment/147249","id":147249,
     * "listimage":"/static/images/2015/10/19/1/1548673576B68T.jpg","pubdate":"2015-10-19 07:10",
     * "title":"截至8月底北京单独二孩申请数已突破5万","type":"news",
     * "url":"/static/html/2015/10/19/714C68564A6F1A796D227C48.html"},{"comment":true,
     * "commentlist":"/static/api/news/10007/35/147235/comment_1.json",
     * "commenturl":"/client/user/newComment/147235","id":147235,
     * "listimage":"/static/images/2015/10/18/23/1564996880735Y.jpg","pubdate":"2015-10-18
     * 07:09","title":"京郊188村今冬取暖不再烧煤","type":"news",
     * "url":"/static/html/2015/10/18/714C6B554A6F1F7C662E7C44.html"},{"comment":true,
     * "commentlist":"/static/api/news/10007/34/147234/comment_1.json",
     * "commenturl":"/client/user/newComment/147234","id":147234,
     * "listimage":"/static/images/2015/10/18/44/1272136091DHO7.jpg","pubdate":"2015-10-18
     * 07:07","title":"一只警犬是如何养成的","type":"news",
     * "url":"/static/html/2015/10/18/764B6A544065187B6C247D44.html"},{"comment":true,
     * "commentlist":"/static/api/news/10007/33/147233/comment_1.json",
     * "commenturl":"/client/user/newComment/147233","id":147233,
     * "listimage":"/static/images/2015/10/18/9/1595473073IMK6.jpg","pubdate":"2015-10-18 07:05",
     * "title":"万人返校庆清华附校百岁","type":"news",
     * "url":"/static/html/2015/10/18/764B6C524D6810736C247B45.html"},{"comment":true,
     * "commentlist":"/static/api/news/10007/32/147232/comment_1.json",
     * "commenturl":"/client/user/newComment/147232","id":147232,
     * "listimage":"/static/images/2015/10/18/52/384632410EFUL.jpg","pubdate":"2015-10-18 07:03",
     * "title":"地铁8号线拟后年南北分段运营","type":"news",
     * "url":"/static/html/2015/10/18/764B69574F6A1D7E68207B44.html"},{"comment":true,
     * "commentlist":"/static/api/news/10007/31/147231/comment_1.json",
     * "commenturl":"/client/user/newComment/147231","id":147231,
     * "listimage":"/static/images/2015/10/18/21/16000906787NI8.jpg","pubdate":"2015-10-18
     * 07:02","title":"红绿灯停电4小时 惠新西街乱了套","type":"news",
     * "url":"/static/html/2015/10/18/764B6856406510736B237B47.html"},{"comment":true,
     * "commentlist":"/static/api/news/10007/30/147230/comment_1.json",
     * "commenturl":"/client/user/newComment/147230","id":147230,
     * "listimage":"/static/images/2015/10/18/71/1449480296D2X4.jpg","pubdate":"2015-10-18
     * 07:00","title":"5村官私分\u201c7·21\u201d救灾款获刑","type":"news",
     * "url":"/static/html/2015/10/18/774A685640651D7E662E7A47.html"},{"comment":true,
     * "commentlist":"/static/api/news/10007/80/147180/comment_1.json",
     * "commenturl":"/client/user/newComment/147180","id":147180,
     * "listimage":"/static/images/2015/10/17/45/467283561A07.jpg","pubdate":"2015-10-17 08:02",
     * "title":"北京平谷将建369公里环山步道 为迎世界休闲大会","type":"news",
     * "url":"/static/html/2015/10/17/734E6658496C1E7E692A714C.html"},{"comment":true,
     * "commentlist":"/static/api/news/10007/78/147178/comment_1.json",
     * "commenturl":"/client/user/newComment/147178","id":147178,
     * "listimage":"/static/images/2015/10/17/9/467283563O94.jpg","pubdate":"2015-10-17 07:40",
     * "title":"今年本市实现\u201c山山有红叶\u201d","type":"news",
     * "url":"/static/html/2015/10/17/714C68564E6B1E7E6A267C49.html"},{"comment":true,
     * "commentlist":"/static/api/news/10007/77/147177/comment_1.json",
     * "commenturl":"/client/user/newComment/147177","id":147177,
     * "listimage":"/static/images/2015/10/17/53/46728356ZI2W.jpg","pubdate":"2015-10-17 07:37",
     * "title":"北风今晚驱霾 北京明日重现蓝天","type":"news",
     * "url":"/static/html/2015/10/17/774A6D534E6B1D7D6D217A40.html"},{"comment":true,
     * "commentlist":"/static/api/news/10007/75/147175/comment_1.json",
     * "commenturl":"/client/user/newComment/147175","id":147175,
     * "listimage":"/static/images/2015/10/17/24/467283561T1P.jpg","pubdate":"2015-10-17 07:32",
     * "title":"首都机场首设鸟情监测站","type":"news",
     * "url":"/static/html/2015/10/17/704D6C52486D1E7E6E227D45.html"},{"comment":true,
     * "commentlist":"/static/api/news/10007/74/147174/comment_1.json",
     * "commenturl":"/client/user/newComment/147174","id":147174,
     * "listimage":"/static/images/2015/10/17/26/4672835699VK.jpg","pubdate":"2015-10-17 07:29",
     * "title":"门头沟举办重阳文化活动","type":"news",
     * "url":"/static/html/2015/10/17/714C68564F6A1E7E69257C45.html"},{"comment":true,
     * "commentlist":"/static/api/news/10007/73/147173/comment_1.json",
     * "commenturl":"/client/user/newComment/147173","id":147173,
     * "listimage":"/static/images/2015/10/17/86/46728356TG86.jpg","pubdate":"2015-10-17 07:26",
     * "title":"登山锻炼赏金秋美景","type":"news","url":"/static/html/2015/10/17/764B6957496C1D7D6C207E40
     * .html"},{"comment":true,"commentlist":"/static/api/news/10007/68/147168/comment_1.json",
     * "commenturl":"/client/user/newComment/147168","id":147168,
     * "listimage":"/static/images/2015/10/16/91/420532629LCKI.jpg","pubdate":"2015-10-16 16:38",
     * "title":"【京城志】关于\u201c出轨\u201d的那点事儿","type":"news",
     * "url":"/static/html/2015/10/16/714C685640651C7C6C217C49.html"},{"comment":true,
     * "commentlist":"/static/api/news/10007/67/147167/comment_1.json",
     * "commenturl":"/client/user/newComment/147167","id":147167,
     * "listimage":"/static/images/2015/10/16/94/619695879ZS51.jpg","pubdate":"2015-10-16 15:31",
     * "title":"故宫门票全部网络销售尚无具体实施时间","type":"news",
     * "url":"/static/html/2015/10/16/754867594C691F7F672A7842.html"}],"title":"北京","topic":[],
     * "topnews":[{"comment":true,"commentlist":"/static/api/news/10007/53/147253/comment_1
     * .json","commenturl":"/client/user/newComment/147253","id":147253,"pubdate":"2015-10-19
     * 07:18","title":"市教委：中高考英语试卷结构不变","topimage":"/static/images/2015/10/19/36/1053274969EORV
     * .jpg","type":"news","url":"/static/html/2015/10/19/714C6E504A6F1B7869277C42.html"},{
     * "comment":true,"commentlist":"/static/api/news/10007/54/147254/comment_1.json",
     * "commenturl":"/client/user/newComment/147254","id":147254,"pubdate":"2015-10-19 07:22",
     * "title":"警方披露\u201c二环十三郎\u201d审讯内容",
     * "topimage":"/static/images/2015/10/19/14/105235144895YS.jpg","type":"news",
     * "url":"/static/html/2015/10/19/724F6B554E6B1D7E68267C45.html"},{"id":147315,"title":"百年彭家寨
     * \u201c国保\u201d吊脚楼","topimage":"/static/images/2015/10/20/80/467283565SGJ.jpg",
     * "url":"/static/html/2015/10/20/754868564D681E7C68227840.html","pubdate":"2015-10-20
     * 09:57","comment":true,"commenturl":"/client/user/newComment/147315","type":"news",
     * "commentlist":"/static/api/news/10012/15/147315/comment_1.json"},{"id":147274,
     * "title":"年度最佳旅行地 让你砰然心动","topimage":"/static/images/2015/10/19/70/467283565C7N.jpg",
     * "url":"/static/html/2015/10/19/704D6C524D681D7E6D217D44.html","pubdate":"2015-10-19
     * 11:42","comment":true,"commenturl":"/client/user/newComment/147274","type":"news",
     * "commentlist":"/static/api/news/10012/74/147274/comment_1.json"}]}
     * retcode : 200
     */

    private DataBean data;
    private int retcode;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public static class DataBean {
        /**
         * countcommenturl : /client/content/countComment/
         * more : /static/api/news/10007/list_2.json
         * news : [{"comment":true,"commentlist":"/static/api/news/10007/61/147261/comment_1
         * .json","commenturl":"/client/user/newComment/147261","id":147261,
         * "listimage":"/static/images/2015/10/19/34/1987564164OD60.jpg","pubdate":"2015-10-19
         * 07:44","title":"河北\u201c大头娃娃\u201d出生即患脑积水 与母蜗居30年","type":"news",
         * "url":"/static/html/2015/10/19/75486F51496C197A6F227844.html"},{"comment":true,
         * "commentlist":"/static/api/news/10007/51/147251/comment_1.json",
         * "commenturl":"/client/user/newComment/147251","id":147251,
         * "listimage":"/static/images/2015/10/19/35/1987564164595O.jpg","pubdate":"2015-10-19
         * 07:17","title":"香山公园发布四条赏红路线","type":"news",
         * "url":"/static/html/2015/10/19/724F6E50486D1D7E69277F43.html"},{"comment":true,
         * "commentlist":"/static/api/news/10007/49/147249/comment_1.json",
         * "commenturl":"/client/user/newComment/147249","id":147249,
         * "listimage":"/static/images/2015/10/19/1/1548673576B68T.jpg","pubdate":"2015-10-19
         * 07:10","title":"截至8月底北京单独二孩申请数已突破5万","type":"news",
         * "url":"/static/html/2015/10/19/714C68564A6F1A796D227C48.html"},{"comment":true,
         * "commentlist":"/static/api/news/10007/35/147235/comment_1.json",
         * "commenturl":"/client/user/newComment/147235","id":147235,
         * "listimage":"/static/images/2015/10/18/23/1564996880735Y.jpg","pubdate":"2015-10-18
         * 07:09","title":"京郊188村今冬取暖不再烧煤","type":"news",
         * "url":"/static/html/2015/10/18/714C6B554A6F1F7C662E7C44.html"},{"comment":true,
         * "commentlist":"/static/api/news/10007/34/147234/comment_1.json",
         * "commenturl":"/client/user/newComment/147234","id":147234,
         * "listimage":"/static/images/2015/10/18/44/1272136091DHO7.jpg","pubdate":"2015-10-18
         * 07:07","title":"一只警犬是如何养成的","type":"news",
         * "url":"/static/html/2015/10/18/764B6A544065187B6C247D44.html"},{"comment":true,
         * "commentlist":"/static/api/news/10007/33/147233/comment_1.json",
         * "commenturl":"/client/user/newComment/147233","id":147233,
         * "listimage":"/static/images/2015/10/18/9/1595473073IMK6.jpg","pubdate":"2015-10-18
         * 07:05","title":"万人返校庆清华附校百岁","type":"news",
         * "url":"/static/html/2015/10/18/764B6C524D6810736C247B45.html"},{"comment":true,
         * "commentlist":"/static/api/news/10007/32/147232/comment_1.json",
         * "commenturl":"/client/user/newComment/147232","id":147232,
         * "listimage":"/static/images/2015/10/18/52/384632410EFUL.jpg","pubdate":"2015-10-18
         * 07:03","title":"地铁8号线拟后年南北分段运营","type":"news",
         * "url":"/static/html/2015/10/18/764B69574F6A1D7E68207B44.html"},{"comment":true,
         * "commentlist":"/static/api/news/10007/31/147231/comment_1.json",
         * "commenturl":"/client/user/newComment/147231","id":147231,
         * "listimage":"/static/images/2015/10/18/21/16000906787NI8.jpg","pubdate":"2015-10-18
         * 07:02","title":"红绿灯停电4小时 惠新西街乱了套","type":"news",
         * "url":"/static/html/2015/10/18/764B6856406510736B237B47.html"},{"comment":true,
         * "commentlist":"/static/api/news/10007/30/147230/comment_1.json",
         * "commenturl":"/client/user/newComment/147230","id":147230,
         * "listimage":"/static/images/2015/10/18/71/1449480296D2X4.jpg","pubdate":"2015-10-18
         * 07:00","title":"5村官私分\u201c7·21\u201d救灾款获刑","type":"news",
         * "url":"/static/html/2015/10/18/774A685640651D7E662E7A47.html"},{"comment":true,
         * "commentlist":"/static/api/news/10007/80/147180/comment_1.json",
         * "commenturl":"/client/user/newComment/147180","id":147180,
         * "listimage":"/static/images/2015/10/17/45/467283561A07.jpg","pubdate":"2015-10-17
         * 08:02","title":"北京平谷将建369公里环山步道 为迎世界休闲大会","type":"news",
         * "url":"/static/html/2015/10/17/734E6658496C1E7E692A714C.html"},{"comment":true,
         * "commentlist":"/static/api/news/10007/78/147178/comment_1.json",
         * "commenturl":"/client/user/newComment/147178","id":147178,
         * "listimage":"/static/images/2015/10/17/9/467283563O94.jpg","pubdate":"2015-10-17
         * 07:40","title":"今年本市实现\u201c山山有红叶\u201d","type":"news",
         * "url":"/static/html/2015/10/17/714C68564E6B1E7E6A267C49.html"},{"comment":true,
         * "commentlist":"/static/api/news/10007/77/147177/comment_1.json",
         * "commenturl":"/client/user/newComment/147177","id":147177,
         * "listimage":"/static/images/2015/10/17/53/46728356ZI2W.jpg","pubdate":"2015-10-17
         * 07:37","title":"北风今晚驱霾 北京明日重现蓝天","type":"news",
         * "url":"/static/html/2015/10/17/774A6D534E6B1D7D6D217A40.html"},{"comment":true,
         * "commentlist":"/static/api/news/10007/75/147175/comment_1.json",
         * "commenturl":"/client/user/newComment/147175","id":147175,
         * "listimage":"/static/images/2015/10/17/24/467283561T1P.jpg","pubdate":"2015-10-17
         * 07:32","title":"首都机场首设鸟情监测站","type":"news",
         * "url":"/static/html/2015/10/17/704D6C52486D1E7E6E227D45.html"},{"comment":true,
         * "commentlist":"/static/api/news/10007/74/147174/comment_1.json",
         * "commenturl":"/client/user/newComment/147174","id":147174,
         * "listimage":"/static/images/2015/10/17/26/4672835699VK.jpg","pubdate":"2015-10-17
         * 07:29","title":"门头沟举办重阳文化活动","type":"news",
         * "url":"/static/html/2015/10/17/714C68564F6A1E7E69257C45.html"},{"comment":true,
         * "commentlist":"/static/api/news/10007/73/147173/comment_1.json",
         * "commenturl":"/client/user/newComment/147173","id":147173,
         * "listimage":"/static/images/2015/10/17/86/46728356TG86.jpg","pubdate":"2015-10-17
         * 07:26","title":"登山锻炼赏金秋美景","type":"news",
         * "url":"/static/html/2015/10/17/764B6957496C1D7D6C207E40.html"},{"comment":true,
         * "commentlist":"/static/api/news/10007/68/147168/comment_1.json",
         * "commenturl":"/client/user/newComment/147168","id":147168,
         * "listimage":"/static/images/2015/10/16/91/420532629LCKI.jpg","pubdate":"2015-10-16
         * 16:38","title":"【京城志】关于\u201c出轨\u201d的那点事儿","type":"news",
         * "url":"/static/html/2015/10/16/714C685640651C7C6C217C49.html"},{"comment":true,
         * "commentlist":"/static/api/news/10007/67/147167/comment_1.json",
         * "commenturl":"/client/user/newComment/147167","id":147167,
         * "listimage":"/static/images/2015/10/16/94/619695879ZS51.jpg","pubdate":"2015-10-16
         * 15:31","title":"故宫门票全部网络销售尚无具体实施时间","type":"news",
         * "url":"/static/html/2015/10/16/754867594C691F7F672A7842.html"}]
         * title : 北京
         * topic : []
         * topnews : [{"comment":true,"commentlist":"/static/api/news/10007/53/147253/comment_1
         * .json","commenturl":"/client/user/newComment/147253","id":147253,"pubdate":"2015-10-19
         * 07:18","title":"市教委：中高考英语试卷结构不变",
         * "topimage":"/static/images/2015/10/19/36/1053274969EORV.jpg","type":"news",
         * "url":"/static/html/2015/10/19/714C6E504A6F1B7869277C42.html"},{"comment":true,
         * "commentlist":"/static/api/news/10007/54/147254/comment_1.json",
         * "commenturl":"/client/user/newComment/147254","id":147254,"pubdate":"2015-10-19
         * 07:22","title":"警方披露\u201c二环十三郎\u201d审讯内容",
         * "topimage":"/static/images/2015/10/19/14/105235144895YS.jpg","type":"news",
         * "url":"/static/html/2015/10/19/724F6B554E6B1D7E68267C45.html"},{"id":147315,
         * "title":"百年彭家寨 \u201c国保\u201d吊脚楼",
         * "topimage":"/static/images/2015/10/20/80/467283565SGJ.jpg",
         * "url":"/static/html/2015/10/20/754868564D681E7C68227840.html","pubdate":"2015-10-20
         * 09:57","comment":true,"commenturl":"/client/user/newComment/147315","type":"news",
         * "commentlist":"/static/api/news/10012/15/147315/comment_1.json"},{"id":147274,
         * "title":"年度最佳旅行地 让你砰然心动","topimage":"/static/images/2015/10/19/70/467283565C7N.jpg",
         * "url":"/static/html/2015/10/19/704D6C524D681D7E6D217D44.html","pubdate":"2015-10-19
         * 11:42","comment":true,"commenturl":"/client/user/newComment/147274","type":"news",
         * "commentlist":"/static/api/news/10012/74/147274/comment_1.json"}]
         */

        private String countcommenturl;
        private String more;
        private String title;
        private List<NewsBean> news;
        private List<?> topic;
        private List<TopnewsBean> topnews;

        public String getCountcommenturl() {
            return countcommenturl;
        }

        public void setCountcommenturl(String countcommenturl) {
            this.countcommenturl = countcommenturl;
        }

        public String getMore() {
            return more;
        }

        public void setMore(String more) {
            this.more = more;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<NewsBean> getNews() {
            return news;
        }

        public void setNews(List<NewsBean> news) {
            this.news = news;
        }

        public List<?> getTopic() {
            return topic;
        }

        public void setTopic(List<?> topic) {
            this.topic = topic;
        }

        public List<TopnewsBean> getTopnews() {
            return topnews;
        }

        public void setTopnews(List<TopnewsBean> topnews) {
            this.topnews = topnews;
        }

        public static class NewsBean {
            /**
             * comment : true
             * commentlist : /static/api/news/10007/61/147261/comment_1.json
             * commenturl : /client/user/newComment/147261
             * id : 147261
             * listimage : /static/images/2015/10/19/34/1987564164OD60.jpg
             * pubdate : 2015-10-19 07:44
             * title : 河北“大头娃娃”出生即患脑积水 与母蜗居30年
             * type : news
             * url : /static/html/2015/10/19/75486F51496C197A6F227844.html
             */

            private boolean comment;
            private String commentlist;
            private String commenturl;
            private int id;
            private String listimage;
            private String pubdate;
            private String title;
            private String type;
            private String url;

            public boolean isComment() {
                return comment;
            }

            public void setComment(boolean comment) {
                this.comment = comment;
            }

            public String getCommentlist() {
                return commentlist;
            }

            public void setCommentlist(String commentlist) {
                this.commentlist = commentlist;
            }

            public String getCommenturl() {
                return commenturl;
            }

            public void setCommenturl(String commenturl) {
                this.commenturl = commenturl;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getListimage() {
                return listimage;
            }

            public void setListimage(String listimage) {
                this.listimage = listimage;
            }

            public String getPubdate() {
                return pubdate;
            }

            public void setPubdate(String pubdate) {
                this.pubdate = pubdate;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class TopnewsBean {
            /**
             * comment : true
             * commentlist : /static/api/news/10007/53/147253/comment_1.json
             * commenturl : /client/user/newComment/147253
             * id : 147253
             * pubdate : 2015-10-19 07:18
             * title : 市教委：中高考英语试卷结构不变
             * topimage : /static/images/2015/10/19/36/1053274969EORV.jpg
             * type : news
             * url : /static/html/2015/10/19/714C6E504A6F1B7869277C42.html
             */

            private boolean comment;
            private String commentlist;
            private String commenturl;
            private int id;
            private String pubdate;
            private String title;
            private String topimage;
            private String type;
            private String url;

            public boolean isComment() {
                return comment;
            }

            public void setComment(boolean comment) {
                this.comment = comment;
            }

            public String getCommentlist() {
                return commentlist;
            }

            public void setCommentlist(String commentlist) {
                this.commentlist = commentlist;
            }

            public String getCommenturl() {
                return commenturl;
            }

            public void setCommenturl(String commenturl) {
                this.commenturl = commenturl;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getPubdate() {
                return pubdate;
            }

            public void setPubdate(String pubdate) {
                this.pubdate = pubdate;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTopimage() {
                return topimage;
            }

            public void setTopimage(String topimage) {
                this.topimage = topimage;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
