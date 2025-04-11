package enjoyTrip.algo;

import java.util.ArrayList;
import java.util.List;

public class dummyDTO {

    // 관광지 정보를 저장할 클래스 정의
    public static class TourismInfo {
        private int no;
        private int contentId;
        private String title;
        private int contentTypeId;
        private int areaCode;
        private int siGunGuCode;
        private String firstImage1;
        private String firstImage2;
        private int mapLevel;
        private double latitude;
        private double longitude;
        private String tel;
        private String addr1;
        private String addr2;
        private String homepage;
        private String overview;

        public TourismInfo(int no, int contentId, String title, int contentTypeId, int areaCode,
                int siGunGuCode, String firstImage1, String firstImage2, int mapLevel,
                double latitude, double longitude, String tel, String addr1, String addr2,
                String homepage, String overview) {
            this.no = no;
            this.contentId = contentId;
            this.title = title;
            this.contentTypeId = contentTypeId;
            this.areaCode = areaCode;
            this.siGunGuCode = siGunGuCode;
            this.firstImage1 = firstImage1;
            this.firstImage2 = firstImage2;
            this.mapLevel = mapLevel;
            this.latitude = latitude;
            this.longitude = longitude;
            this.tel = tel;
            this.addr1 = addr1;
            this.addr2 = addr2;
            this.homepage = homepage;
            this.overview = overview;
        }

        // Getters
        public int getNo() {
            return no;
        }

        public int getContentId() {
            return contentId;
        }

        public String getTitle() {
            return title;
        }

        public int getContentTypeId() {
            return contentTypeId;
        }

        public int getAreaCode() {
            return areaCode;
        }

        public int getSiGunGuCode() {
            return siGunGuCode;
        }

        public String getFirstImage1() {
            return firstImage1;
        }

        public String getFirstImage2() {
            return firstImage2;
        }

        public int getMapLevel() {
            return mapLevel;
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public String getTel() {
            return tel;
        }

        public String getAddr1() {
            return addr1;
        }

        public String getAddr2() {
            return addr2;
        }

        public String getHomepage() {
            return homepage;
        }

        public String getOverview() {
            return overview;
        }

        @Override
        public String toString() {
            return "TourismInfo{" +
                    "no=" + no +
                    ", contentId=" + contentId +
                    ", title='" + title + '\'' +
                    ", contentTypeId=" + contentTypeId +
                    ", areaCode=" + areaCode +
                    ", siGunGuCode=" + siGunGuCode +
                    ", latitude=" + latitude +
                    ", longitude=" + longitude +
                    ", tel='" + tel + '\'' +
                    ", addr1='" + addr1 + '\'' +
                    ", addr2='" + addr2 + '\'' +
                    '}';
        }
    }

    // 하드코딩된 관광지 데이터
    public static final List<TourismInfo> TOURISM_DATA = new ArrayList<TourismInfo>() {
        {
            add(new TourismInfo(
                    56644, 2733967, "가회동성당", 12, 1, 23,
                    "http://tong.visitkorea.or.kr/cms/resource/09/3303909_image2_1.jpg",
                    "http://tong.visitkorea.or.kr/cms/resource/09/3303909_image3_1.jpg",
                    6, 37.58208588280000000, 126.98466168560000000, "",
                    "서울특별시 종로구 북촌로 57 (가회동)", "",
                    "<a href=\"https://gahoe.or.kr\" target=\"_blank\" title=\"새창 : 가회동성당 사이트로 이동\">https://gahoe.or.kr</a>",
                    "가회동성당이 위치한 북촌 일대는 최초의 선교사 주문모(周文謨, 야고보) 신부가 조선에 밀입국하여 1795년 4월 5일 부활 대축일에 최인길(崔仁吉, 마티아)의 집에서 조선 땅에서의 '첫 미사'를 집전한 지역이다. 본당 관할구역은 주문모 신부가 강완숙(姜完淑, 골롬바)의 집에 숨어 지내면서 사목활동을 펼쳤던 지역으로서 한국 교회사에서 매우 중요한 의미가 있다.정식으로 본당이 된 것은 1949년이고, 이후 1954년에 성전이 완공되었다. 하지만 성전이 낡아 2011년부터 옛 성전을 허물고 현재의 새 성전을 짓게 되었다. 2013년 11월 21일 준공되었고, 준공 3일 후인 24일(그리스도 왕 대축일)에 입주하여 입주 미사를 봉헌하였다. 현재의 동서양 건축양식이 어우러진 새 성전은 과거의 역사를 되살리고자 2014년 4월 20일 부활 대축일에 서울교구장 염수정 추기경님에 의하여 축성되었다.(출처 : 가회동성당 홈페이지)"));

            add(new TourismInfo(
                    56645, 2763807, "간데메공원", 12, 1, 11,
                    "", "",
                    6, 37.57283533820000000, 127.04907830050000000, "",
                    "서울특별시 동대문구 서울시립대로2길 59 (답십리동)", "",
                    "",
                    "간데메공원은 서울 동대문구 답십리 천변에 위치한 근린공원이다. 어린이 놀이터와 연못, 팔각정 정자, 장미 넝쿨 터널, 소나무 쉼터, 맨발산책로까지 작지만 아기자기하게 조성된 공원이다. 농구장과 배드민턴장도 있다. 전매청 자리를 공원으로 조성하면서 옛날 답십리 일대 간데메(中山) 자연 부락 마을의 토박이 이름을 따서 간데메공원이라 이름을 정했다고 한다."));

            add(new TourismInfo(
                    56646, 1116925, "갈산근린공원", 12, 1, 19,
                    "http://tong.visitkorea.or.kr/cms/resource/90/3467490_image2_1.jpg",
                    "http://tong.visitkorea.or.kr/cms/resource/90/3467490_image3_1.jpg",
                    6, 37.50611763140000000, 126.86841053580000000, "",
                    "서울특별시 양천구 신정동 162-56", "",
                    "<a href=\"http://www.yangcheon.go.kr/\" target=\"_blank\" title=\"새창: 양천구 \">http://www.yangcheon.go.kr/</a>",
                    "대체로 산세가 둥근 양천구의 다른 산들과는 달리 갈산은 동쪽 부분이 벼랑처럼 깎인 절경을 뽐낸다. 안양천의 오랜 침식작용으로 산 정상이 칼날처럼 변한 것으로 '칼산'이라는 이름으로 불리다가 '갈산'으로 순화되었다. 갈산 입구에는 어린이 교통공원이 들어서 있고, 중턱에는 중심광장과 산책로 등의 쉼터 그리고 정상에는 전망대가 있어 양천을 한눈에 감상할 수 있다. 갈산 정상에는 '갈산정'과 함께 그 옆으로 우리나라 최초의 '대삼각본점'이 설치되어 있다. 이 삼각점은 모든 측량의 기준이 되는 중요한 국가시설물로 1910년 6월 우리나라 최초로 토지조사 사업을 위해 설치한 측량기준점으로 서울시 미래유산으로 지정된 양천구의 중요한 문화유산이다."));

            // 더 많은 데이터를 추가할 수 있습니다...
            // 데이터가 매우 많기 때문에 일부만 추가했습니다.

            // 데이터 추가 예시
            add(new TourismInfo(
                    56647, 294439, "감로암(서울)", 12, 1, 23,
                    "http://tong.visitkorea.or.kr/cms/resource/22/3481922_image2_1.jpg",
                    "http://tong.visitkorea.or.kr/cms/resource/22/3481922_image3_1.jpg",
                    6, 37.57538150160000000, 127.00665153830000000, "",
                    "서울특별시 종로구 율곡로23길 16 (충신동)", "",
                    "",
                    "동대문에서 대학로로 들어가는 율곡로 대로변에 자그마한 사찰이 있다. 그 이름도 특이하게 목마른 중생에게 구제의 감로를 준다는 '감로암'이다. 도심 속 삭막한 빌딩 숲 사이에 아직 개발되지 않은 주택가에 정말 도심에서 보기 힘든 자그마한 암자가 있다. 감로암의 역사는 벌써 100여 년이 흘렀다. 대로변에서 주택가로 나 있는 골목길을 따라 들어서면 보이는 곳에 여느 주택과 별반 차이 없이 건물을 지어 불상을 봉안하고 예배하고 있다. 하지만 여법하게 산문을 만들고 단청을 하며, 기와를 엮어 고풍스러운 가람의 멋을 느끼게 한다. 예부터 관음영험도량으로 알려진 감로암은 동네 어르신들, 특히 할머니들의 다담방, 기도처로 알려져 있다. 감로암은 사찰의 이름처럼 누군가 구제받을 수 있고, 고통에서 벗어날 수 있는 감로가 있는 곳이다. 지금은 마시지 못하지만 보타전 아래에는 여전히 그 옛날 감로의 맛을 느끼게 했던 감로가 흐르고 있다."));

            add(new TourismInfo(
                    56648, 264570, "강남", 12, 1, 1,
                    "http://tong.visitkorea.or.kr/cms/resource/08/1984608_image2_1.jpg",
                    "http://tong.visitkorea.or.kr/cms/resource/08/1984608_image3_1.jpg",
                    6, 37.49704654290000000, 127.02815735370000000, "",
                    "서울특별시 강남구 역삼동", "(역삼동)",
                    "<a href=\"http://www.gangnam.go.kr/main.do\" target=\"_blank\" title=\"새창:  강남구청 \">http://www.gangnam.go.kr/main.do</a>",
                    "강남역 주변은 강남 지역에 있어서 교통의 핵심인 곳이다. 강남대로를 중심으로 동쪽으로는 테헤란로가 뻗어 있어 잠실 방향과 이어지며, 서쪽으로는 사당 방면으로 연결된다. 교보타워 사거리에서 좌측으로는 고속터미널과 이어져 노량진 및 서부 서울로 연결되며, 그대로 북쪽으로는 한남대교를 거쳐 강북으로 연결된다. 그리고 남쪽으로는 양재를 거쳐 분당 등의 신도시와 성남시 등 수도권으로 연결된다. 많은 유동인구가 강남역으로 모이는 이유는 강남역 부근이 만남을 위한 약속장소로 적합하기 때문이다. 각종 모임이나 행사 또는 개인적인 만남을 갖기에 좋은 지역적, 상권적 특성을 지니고 있다. 따라서 평일에는 주로 저녁 시간대, 주말의 경우는 낮부터 강남역 10, 11번 출구, 롯데시네마 앞(구, 시티극장), 지오다노 매장 앞 등에서 많은 사람들로 붐비는 것을 흔히 볼 수 있다.편리한 교통과 다수의 패션 관련 매장, 극장, 대형서점 등 소비를 하기 좋은 이러한 환경이 거리가 먼 지역의 소비자들까지 강남역으로 모이게 하고 있다. 강남구에서는 내ㆍ외국인 관광객에게 종합관광서비스는 물론, 강남구의 우수 인프라인 의료와 한류에 대하여 보고, 느끼고, 즐길 수 있는 체험형 관광거점시설인 강남관광정보센터를 건립ㆍ운영하고 있으며, 강남관광정보센터는 서울과 강남의 주요 관광명소를 안내하고 관광객 편의시설을 갖춘 '종합관광안내센터'와 강남구 특화 병원과 진료 프로그램을 소개하고 체험할 수 있는 '메디컬투어센터', 한류 스타를 활용하여 다양한 한류체험이 가능한 '한류체험관'으로 구성되어 있다."));

            add(new TourismInfo(
                    56649, 2456536, "강남 마이스 관광특구", 12, 1, 1,
                    "http://tong.visitkorea.or.kr/cms/resource/13/3464913_image2_1.jpg",
                    "http://tong.visitkorea.or.kr/cms/resource/13/3464913_image3_1.jpg",
                    6, 37.51180927460000000, 127.05913189450000000, "",
                    "서울특별시 강남구 영동대로 513", "(삼성동)",
                    "",
                    "일찍이 무역센터가 자리 잡으며 국제 교류의 메카로 손꼽혀온 강남 삼성동 일대는, 세계에서 모여든 최첨단 비즈니스맨에게 한국을 알리는 창구 역할을 해왔다. 여기에 1990년대부터 강남 특유의 젊은 문화가 유입되면서 무역센터 일대는 비즈니스의 장이자 젊은 문화의 랜드마크라는 복합적인 성격을 띠며 발전했다. 2014년 싸이의 '강남스타일' 열풍과 더불어 국제교류 비즈니스 산업과 한류문화의 공생을 강화하기 위해 이 일대가 강남 마이스 관광특구로 지정되었다. 강남 마이스 관광특구는 전시와 컨벤션, 세미나, 국제 전시회, 콘퍼런스 등이 이어지는 코엑스를 중심으로 자리 잡고 있고, 백화점, 호텔, 면세점, 도심공항터미널이 유기적으로 모여 있어, 국내뿐만이 아니라 외국인 관광객이 끊이지 않는다. 강남 마이스 관광특구 일대는 한국판 타임스퀘어로 조성되어 최첨단 디스플레이를 활용해 홀로그램과 증강현실을 체험하고, 건물 외벽에 설치된 초대형 LED 전광판에서 표출되는 화려한 미디어아트와 광고를 감상할 수 있다."));

            add(new TourismInfo(
                    56650, 127377, "강동예찬시비", 12, 1, 2,
                    "", "",
                    6, 37.54268735350000000, 127.12070041400000000, "",
                    "서울특별시 강동구 천호동", "",
                    "<a href=\"https://www.gangdong.go.kr/web/culture/contents/gdc020_050_010\" target=\"_blank\" title=\"새창 : 강동문화포털 홈페이지로 이동\">https://www.gangdong.go.kr</a>",
                    "강동예찬시비는 서울 정도 600년을 기념하기 위하여, 조선 초기의 서거정이 지은 해 질 무렵의 한강변과 강동지역의 아름다운 전원충경을 노래한 시를 옛 광나루였던 광진교 입구에 한강의 쌍돛배의 모습으로 건립한 것이다. 일찍이 6,000년 전에 선사시대의 조상들이 살았으며 삼국시대에 국가의 요충지로 중요시되었던 광나루는, 조선시대에 한강의 5대 나루터의 하나로 번성하였으며 한양에서 한양 뱃길을 건너 구천면 길을 지나는 왕의 능 참배길로도 이용되었다. 이처럼 광나루는 역사적 의미가 클 뿐만 아니라 주변 경관이 수려하여 많은 시민, 묵객 등이 즐겨 찾던 곳이다. 따라서 강동예찬시비는 한강을 조망하는 훌륭한 쉼터이자 지방자치시대를 맞아 지역주민들이 고장에 대한 자긍심과 애향심을 간직할 수 있는 한강변의 문화명소이다."));

            add(new TourismInfo(
                    56651, 128961, "강변스파랜드", 12, 1, 6,
                    "http://tong.visitkorea.or.kr/cms/resource/98/3401698_image2_1.JPG",
                    "http://tong.visitkorea.or.kr/cms/resource/98/3401698_image3_1.JPG",
                    6, 37.53482663050000000, 127.09161161810000000, "",
                    "서울특별시 광진구 구의강변로 45", "(구의동)",
                    "<a href=\"http://ispaland.co.kr/\"target=\"_blank\" title=\"새창:강변스파랜드\">http://ispaland.co.kr/</a>",
                    "강변스파랜드는 지하 1·2층, 9917.4m²(3,000평) 규모의 사우나를 즐길 수 있는 대규모 스파 시설이다. 재래식 불한증막과 찜질방, 사우나 등의 시설 이용과 함께 한 차원 높은 문화공간 체험이 가능한 곳이다. 지하 2층은 사우나, 지하 1층은 공용 찜질방이다. 세련된 인테리어와 유황 성분이 함유된 지하수 사우나 물은 매끄럽고 피부에도 좋다고 한다. 재래식 소나무장작불한증막, 넓은 공용 홀을 비롯하여 숯방, 소금방, 은피라미드방, 여성전용황토불가마, 황토방, 이글루체험방 등 다양한 찜질방과 온탕, 냉탕, 아쿠아워킹·마사지탕, 습식사우나, 건식사우나 등 각종 사우나시설을 즐길 수 있다. 부대시설로는 모임방, 어린이놀이방, 당구장, 탁구장, 대형게임장, 충전카페, 피부관리실이 있으며 한식당과 치킨·스낵코너에서 식사와 간단한 요깃거리를 해결할 수 있다.  강변스파랜드는 수도권 지하철 2호선 강변역 4번 출구에서 약 340m 정도 떨어진 위치에 있다."));

            add(new TourismInfo(
                    56652, 809490, "강서습지생태공원", 12, 1, 4,
                    "", "",
                    6, 37.58608797690000000, 126.81714907320000000, "",
                    "서울특별시 강서구 양천로27길 279-23", "(방화동)",
                    "▪ <a href=\"https://hangang.seoul.go.kr/www/contents/675.do?mid=482\" target=\"_blank\" title=\"새창 : 홈페이지로 이동\">https://hangang.seoul.go.kr</a>",
                    "방화대교 남쪽 끝에서 행주대교 남쪽 끝 사이 한강 둔치에 있는 생태공원이다. 서울시 생태관광명소 30개소 중 하나로 선정된 강서습지생태공원은 담수지·저습지 등을 조성하고 습생·수생식물을 심은 습지 공원으로 2002년 7월에 개원되었다. 물억새 등 습지식물을 식재하여 새들이 휴식을 취할 수 있도록 하였으며 하중도, 자연관찰로, 습초지 등 습지 생태계를 복원하여 하천의 자연정화 기능을 극대화하고 있다. 습지를 가로질러 두 곳의 탐방로와 조류 조망대 등이 있는데 조류전망대에서는 행주대교와 방화대교, 한강을 한눈에 볼 수 있다. 또한 방화대교 하부, 가족 피크닉장 앞, 행주대교 하부에는 체력단련기구 등을 갖춰 시민의 여가 활동과 스포츠 공간으로의 기능을 하고 있다. 한강을 따라 자전거길과 산책로가 조성되어 있어 다양한 방법으로 강서습지생태공원을 즐길 수 있다.강서습지생태공원은 생태학습프로그램도 운영하고 있으므로 아이들과 함께 습지생태공원의 프로그램을 참여하여 자연을 공부해 보는 것도 좋다. 생태학습프로그램 참여는 [서울시 공공서비스예약사이트]접속>교육강좌>자연과학>[공원명]으로 검색>프로그램 예약신청 을 하면 된다."));

            add(new TourismInfo(
                    56653, 3043735, "강서역사문화거리", 12, 1, 4,
                    "http://tong.visitkorea.or.kr/cms/resource/09/3045109_image2_1.jpg",
                    "http://tong.visitkorea.or.kr/cms/resource/09/3045109_image3_1.jpg",
                    6, 37.57223438020000000, 126.83666434890000000, "",
                    "서울특별시 강서구 양천로 291 (마곡동)", "",
                    "<a href=\"https://www.gangseo.seoul.kr/munhwa/mh020301\" target=\"_blank\" title=\"새창 : 홈페이지로 이동\">https://www.gangseo.seoul.kr</a>",
                    "강서역사문화거리는 다양한 역사 문화 유적지가 산재한 가양동 일대에 위치한 곳으로, 가양동 일대의 낙후된 경관을 개선해 역사와 문화의 향취가 가득한 거리로 탈바꿈한 것이다. 가양동 궁산 일대는 조선시대 양천현아가 있었던 행정의 중심지인 까닭에 많은 역사 문화유산이 곳곳에 남아있다. 9호선 양천향교역 1번 출구를 나와 마곡지구에서 이어지는 양천로 47길 초입에 설치된 [강서역사문화거리] 임을 알리는 상징 조형물이 세워져 있다. 기둥 형태의 안내판에는 유적지를 소개하는 글과 위치를 담고 있어 누구든 쉽게 유적지를 찾을 수 있다. 겸재정선미술관, 궁산땅굴, 소악루, 양천고성지, 양천향교로 이어지는 강서역사문화거리는 천천히 걸어 1시간 정도 걸리는 코스이다. 해가 저물면 역사문화 거리는 낮의 모습과는 다르게 아름다운 조명이 켜지며 빛을 받은 조형물이 줄을 잇는 모습을 연출한다."));

            // 나머지 데이터를 여기에 추가할 수 있습니다...
        }
    };

    // 테스트 메서드
    public static void main(String[] args) {
        System.out.println("Total tourism data: " + TOURISM_DATA.size());

        // 첫 번째 데이터 출력 예시
        if (!TOURISM_DATA.isEmpty()) {
            System.out.println("First tourism info: " + TOURISM_DATA.get(0));
        }
    }
}