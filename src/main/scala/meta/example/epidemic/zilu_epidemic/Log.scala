//package meta.example.epidemic.zilu_epidemic
//
//import meta.example.epidemic.zilu_epidemic.SEIHCRD._
//
//class Log {
//
//  val log_template: Map[SEIHCRD,Long] = Map(SUSCEPTIBLE -> 0, EXPOSED -> 0, INFECTIOUS -> 0, HOSPITALIZED -> 0, CRITICAL -> 0, RECOVERED -> 0, DECEASED -> 0)
//  var percentile_template: Map[SEIHCRD,Double] = Map(SUSCEPTIBLE -> 0, EXPOSED -> 0, INFECTIOUS -> 0, HOSPITALIZED -> 0, CRITICAL -> 0, RECOVERED -> 0, DECEASED -> 0)
//
//
//  def viewAsPercentile(summary: Summary ):Unit = {
//    var percentile_summary: Map[SEIHCRD,Double] = percentile_template;
//    var population:Int = accumulate(summary.begin(), summary.end(), 0,
//      [](const PopulationSize prev, const pair<PopulationSize, double>& e) {
//      return prev + e.second;
//    });
//    auto it = percentile_summary.begin();
//    for (auto r: summary){
//      it->second = 1.0*(r.second) / population;
//      ++it;
//    }
//
//    for (auto e: percentile_summary){
//      cout << e.second << " ";
//    }
//    cout << endl;
//  }
//
//    map<enum SEIHCRD, long long int> log;
//
//  Log(){
//    log = log_template;
//  }
//
//  map<enum SEIHCRD, long long int> logTemplate(int init_val){
//    map<enum SEIHCRD, long long int> ans = log_template;
//    for (auto e: ans){
//      e.second = init_val;
//    }
//    return ans;
//  }
//
//  Summary aggregateSummary(vector<Summary> regional_summary){
//    Summary aggregate_summary = log_template;
//
//    for (auto regional_map: regional_summary){
//      for (auto s: regional_map){
//        aggregate_summary.find(s.first)->second += s.second;
//      }
//    }
//    return aggregate_summary;
//  }
//
//  void printLog(){
//    for (auto e: log){
//      cout << e.second << " ";
//    }
//    cout << endl;
//  }
//
//  void printPercent(){
//    viewAsPercentile(log);
//  }
//
//  void printPercent(Summary s){
//    viewAsPercentile(s);
//  }
//
//}
