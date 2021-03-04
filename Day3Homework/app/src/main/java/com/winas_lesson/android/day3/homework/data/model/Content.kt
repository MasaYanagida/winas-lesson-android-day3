package com.winas_lesson.android.day3.homework.data.model

import com.winas_lesson.android.day3.homework.BrandIcon

data class Content(
    var name: String = "",
    var address: String = "",
    var description: String = "",
    var imageUrlString: String = "\"http://i.imgur.com/DvpvklR.png\""
) {
    val icons: MutableList<BrandIcon>
        get() {
            var ret = mutableListOf<BrandIcon>()
            if (listOf(true, false).random()) {
                ret.add(BrandIcon.TWITTER)
            }
            if (listOf(true, false).random()) {
                ret.add(BrandIcon.INSTAGRAM)
            }
            if (listOf(true, false).random()) {
                ret.add(BrandIcon.REDDIT)
            }
            if (listOf(true, false).random()) {
                ret.add(BrandIcon.SNAPCHAT)
            }
            return ret
        }
    companion object {
        fun create(): Content {
            val ret = Content()
            ret.name = listOf("佐久間大輝","島奈穂","岩佐泰賀","西結羽","二瓶輝男","室井孝治","三谷和花","畠山富男","深沢由太郎","梅原誠二","上原時子","斉藤琉叶","塩谷亘","岸田祐希","猪俣力","大友真希","高坂喜久雄","三宅光枝","小幡海斗","三木尚生","重松沙耶","山村洋司","阪本剣都","熊谷忠一","福井蒼依","澤田早希","荻野道世","田川京子","谷川悟","滝田弘之").random()
            ret.address = listOf("青森県 五所川原市 不魚住 1-12-13 不魚住マンション310","千葉県 白井市 中 2-6-12","新潟県 三条市 吉野屋 2-11","福岡県 朝倉市 金丸 3-7-15","山梨県 南アルプス市 有野 1-20-6 ヴィレッジ有野205","宮崎県 日向市 浜町 2-12 テラス浜町409","福島県 大沼郡会津美里町 橋丸 1-11","沖縄県 那覇市 松山 2-14","鳥取県 倉吉市 広瀬 1-7 広瀬ガーデン110","広島県 呉市 音戸町波多見 4-11-17","新潟県 村上市 中川原団地 1-7-10 ダイヤモンド中川原団地412","宮城県 気仙沼市 長崎 4-10-20","長野県 小諸市 鴇久保 2-4-18 鴇久保ヴィレッジ209","奈良県 奈良市 佐保台西町 2-4-18","熊本県 人吉市 中青井町 4-19-5","宮崎県 都城市 関之尾町 4-12 関之尾町グリーン418","岩手県 盛岡市 大慈寺町 3-1 大慈寺町荘402","茨城県 行方市 青沼 1-5 青沼ハイツ101","石川県 輪島市 房田町 3-12-11","愛知県 瀬戸市 前田町 1-10-11","滋賀県 大津市 音羽台 3-7-3 音羽台ロイヤル100","大分県 大分市 福宗 1-15-14","東京都 港区 芝公園 3-17-10","埼玉県 春日部市 樋籠 3-1-5 レジデンス樋籠405","鹿児島県 南九州市 頴娃町御領 4-3-13 頴娃町御領荘219","兵庫県 たつの市 揖西町佐江 4-19-17","広島県 廿日市市 佐方 2-20-6 佐方スカイ109","長野県 安曇野市 明科東川手 2-11-5","富山県 高岡市 若保町 4-17-12","滋賀県 長浜市 錦織町 2-19").random()
            ret.description = "新型コロナウイルス感染症のワクチン接種が17日、国内で始まった。第1例目の接種は東京都目黒区の国立病院機構東京医療センターで行われ、医師に米ファイザー製ワクチンが打たれた。政府は国立病院機構の施設など、まず全国100カ所の病院で同意を得た医療従事者4万人に先行接種して安全性を確かめる方針。流行収束に向けてワクチンの効果に期待が高まる。滞りなく接種を進めるための供給確保が課題となる。\\n\\n世界では少なくとも70カ国が日本に先行して接種を始めており、欧米に比べて2カ月遅れのスタートとなった。厚生労働省が海外だけでなく、国内臨床試験の実施を求めたのが主な理由だ。"

            return ret
        }
    }
}
