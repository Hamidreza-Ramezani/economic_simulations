package generated

trait TrafficLightTrait extends meta.deep.runtime.Actor with meta.example.supermarket.goods.newItem {
    var state: Int = 0
  var turn: String = "driver"

    private var resetData_0: scala.Any = null;
  private val resetData_1 = scala.collection.mutable.ListBuffer.apply[scala.collection.immutable.List[scala.Tuple2[scala.Tuple2[scala.Int, scala.Int], scala.Int]]]();
  private var resetData_2: meta.deep.runtime.ResponseMessage = null;
  private var bindingMut_3: scala.Boolean = false;
  private var bindingMut_4: scala.Int = 0;
  private var bindingMut_5: scala.Any = null;
  private var listValMut_6: meta.deep.runtime.RequestMessage = null;
  private var iterMut_7: scala.collection.Iterator[meta.deep.runtime.RequestMessage] = null;
  var timeVar: scala.Int = 0;
  private var positionVar_9: scala.Int = 0;
  
  val commands_112 = (() => {
  val data_10 = new scala.Array[scala.Function0[scala.Unit]](22);
  data_10.update(0, (() => {
    positionVar_9 = 1;
    val x_11 = scala.Tuple2.apply[scala.Int, scala.Int](-1, -1);
    val x_12 = scala.Tuple2.apply[scala.Tuple2[scala.Int, scala.Int], scala.Int](x_11, 18);
    val x_13 = scala.collection.immutable.Nil.::[scala.Tuple2[scala.Tuple2[scala.Int, scala.Int], scala.Int]](x_12);
    resetData_1.prepend(x_13)
  }));
  data_10.update(1, (() => if (true)
    positionVar_9 = 2
  else
    positionVar_9 = 21));
  data_10.update(2, (() => {
    val x_14 = this.popRequestMessages;
    val x_15 = x_14.iterator;
    iterMut_7 = x_15;
    positionVar_9 = 3
  }));
  data_10.update(3, (() => {
    val x_16 = iterMut_7;
    val x_17 = x_16.asInstanceOf[scala.collection.Iterator[meta.deep.runtime.RequestMessage]];
    val x_18 = x_17.hasNext;
    if (x_18)
      {
        val x_19 = iterMut_7;
        val x_20 = x_19.asInstanceOf[scala.collection.Iterator[meta.deep.runtime.RequestMessage]];
        val x_21 = x_20.next();
        listValMut_6 = x_21;
        positionVar_9 = 4
      }
    else
      positionVar_9 = 14
  }));
  data_10.update(4, (() => {
    val x_22 = listValMut_6;
    val x_23 = x_22.asInstanceOf[meta.deep.runtime.RequestMessage];
    val x_24 = x_23.methodId;
    val x_25 = x_24.==(0);
    val x_26 = x_25.`unary_!`;
    if (x_26)
      positionVar_9 = 5
    else
      positionVar_9 = 10
  }));
  data_10.update(5, (() => {
    val x_27 = listValMut_6;
    val x_28 = x_27.asInstanceOf[meta.deep.runtime.RequestMessage];
    val x_29 = x_28.methodId;
    val x_30 = x_29.==(1);
    val x_31 = x_30.`unary_!`;
    if (x_31)
      positionVar_9 = 6
    else
      positionVar_9 = 9
  }));
  data_10.update(6, (() => {
    val x_32 = listValMut_6;
    val x_33 = x_32.asInstanceOf[meta.deep.runtime.RequestMessage];
    val x_34 = x_33.methodId;
    val x_35 = x_34.==(2);
    val x_36 = x_35.`unary_!`;
    if (x_36)
      {
        val x_37 = listValMut_6;
        val x_38 = x_37.asInstanceOf[meta.deep.runtime.RequestMessage];
        val x_39 = scala.collection.immutable.List.apply[meta.deep.runtime.RequestMessage](x_38);
        val x_40 = this.addReceiveMessages(x_39);
        resetData_0 = x_40;
        positionVar_9 = 7
      }
    else
      positionVar_9 = 8
  }));
  data_10.update(7, (() => positionVar_9 = 3));
  data_10.update(8, (() => {
    val x_41 = listValMut_6;
    val x_42 = x_41.asInstanceOf[meta.deep.runtime.RequestMessage];
    val x_43 = x_42.methodId;
    val x_44 = x_43.==(2);
    if (x_44)
      positionVar_9 = 1
    else
      ();
    val x_45 = scala.Tuple2.apply[scala.Int, scala.Int](-1, -1);
    val x_46 = scala.Tuple2.apply[scala.Tuple2[scala.Int, scala.Int], scala.Int](x_45, 17);
    val x_47 = scala.collection.immutable.Nil.::[scala.Tuple2[scala.Tuple2[scala.Int, scala.Int], scala.Int]](x_46);
    resetData_1.prepend(x_47)
  }));
  data_10.update(9, (() => {
    val x_48 = listValMut_6;
    val x_49 = x_48.asInstanceOf[meta.deep.runtime.RequestMessage];
    val x_50 = x_49.methodId;
    val x_51 = x_50.==(1);
    if (x_51)
      {
        scala.Predef.println("Driver is crossing the road");
        resetData_0 = ();
        this.`state_=`(0);
        resetData_0 = ();
        this.`turn_=`("driver");
        resetData_0 = ();
        val x_52 = resetData_0;
        val x_53 = x_52.asInstanceOf[scala.Any];
        bindingMut_5 = x_53;
        val x_54 = bindingMut_5;
        val x_55 = x_54.asInstanceOf[scala.Any];
        val x_56 = listValMut_6;
        val x_57 = x_56.asInstanceOf[meta.deep.runtime.RequestMessage];
        x_57.reply(this, x_55);
        resetData_0 = ();
        positionVar_9 = 7
      }
    else
      ()
  }));
  data_10.update(10, (() => {
    val x_58 = listValMut_6;
    val x_59 = x_58.asInstanceOf[meta.deep.runtime.RequestMessage];
    val x_60 = x_59.methodId;
    val x_61 = x_60.==(0);
    if (x_61)
      {
        val x_62 = this.state;
        resetData_0 = x_62;
        val x_63 = resetData_0;
        val x_64 = x_63.asInstanceOf[scala.Int];
        bindingMut_4 = x_64;
        val x_65 = bindingMut_4;
        val x_66 = x_65.asInstanceOf[scala.Int];
        val x_67 = x_66.==(0);
        resetData_0 = x_67;
        val x_68 = resetData_0;
        val x_69 = x_68.asInstanceOf[scala.Boolean];
        bindingMut_3 = x_69;
        positionVar_9 = 11
      }
    else
      ()
  }));
  data_10.update(11, (() => {
    val x_70 = bindingMut_3;
    val x_71 = x_70.asInstanceOf[scala.Boolean];
    if (x_71)
      {
        this.`state_=`(1);
        resetData_0 = ();
        this.`turn_=`("passenger");
        resetData_0 = ();
        positionVar_9 = 12
      }
    else
      positionVar_9 = 13
  }));
  data_10.update(12, (() => {
    val x_72 = this.turn;
    resetData_0 = x_72;
    val x_73 = resetData_0;
    val x_74 = x_73.asInstanceOf[scala.Any];
    bindingMut_5 = x_74;
    val x_75 = bindingMut_5;
    val x_76 = x_75.asInstanceOf[scala.Any];
    val x_77 = listValMut_6;
    val x_78 = x_77.asInstanceOf[meta.deep.runtime.RequestMessage];
    x_78.reply(this, x_76);
    resetData_0 = ();
    positionVar_9 = 7
  }));
  data_10.update(13, (() => {
    val x_79 = bindingMut_3;
    val x_80 = x_79.asInstanceOf[scala.Boolean];
    val x_81 = x_80.`unary_!`;
    if (x_81)
      {
        this.`state_=`(0);
        resetData_0 = ();
        this.`turn_=`("driver");
        resetData_0 = ();
        positionVar_9 = 12
      }
    else
      ()
  }));
  data_10.update(14, (() => {
    val x_82 = iterMut_7;
    val x_83 = x_82.asInstanceOf[scala.collection.Iterator[meta.deep.runtime.RequestMessage]];
    val x_84 = x_83.hasNext;
    val x_85 = x_84.`unary_!`;
    if (x_85)
      positionVar_9 = 15
    else
      ();
    val x_86 = timeVar;
    val x_87 = x_86.+(1);
    timeVar = x_87
  }));
  data_10.update(15, (() => if (true)
    positionVar_9 = 2
  else
    positionVar_9 = 16));
  data_10.update(16, (() => {
    val x_88 = true.`unary_!`;
    if (x_88)
      {
        val x_89 = resetData_1.remove(0);
        val x_93 = x_89.find(((x_90: scala.Tuple2[scala.Tuple2[scala.Int, scala.Int], scala.Int]) => {
          val x_91 = x_90._1;
          val x_92 = scala.Tuple2.apply[scala.Int, scala.Int](-1, -1);
          x_91.==(x_92)
        }));
        val x_94 = x_93.get;
        val x_95 = x_94._2;
        positionVar_9 = x_95
      }
    else
      ()
  }));
  data_10.update(17, (() => {
    val x_96 = resetData_0;
    val x_97 = x_96.asInstanceOf[scala.Any];
    bindingMut_5 = x_97;
    val x_98 = bindingMut_5;
    val x_99 = x_98.asInstanceOf[scala.Any];
    val x_100 = listValMut_6;
    val x_101 = x_100.asInstanceOf[meta.deep.runtime.RequestMessage];
    x_101.reply(this, x_99);
    resetData_0 = ();
    positionVar_9 = 7
  }));
  data_10.update(18, (() => positionVar_9 = 19));
  data_10.update(19, (() => {
    positionVar_9 = 20;
    val x_102 = timeVar;
    val x_103 = x_102.+(1);
    timeVar = x_103
  }));
  data_10.update(20, (() => positionVar_9 = 19));
  data_10.update(21, (() => {
    val x_104 = true.`unary_!`;
    if (x_104)
      {
        val x_105 = resetData_1.remove(0);
        val x_109 = x_105.find(((x_106: scala.Tuple2[scala.Tuple2[scala.Int, scala.Int], scala.Int]) => {
          val x_107 = x_106._1;
          val x_108 = scala.Tuple2.apply[scala.Int, scala.Int](-1, -1);
          x_107.==(x_108)
        }));
        val x_110 = x_109.get;
        val x_111 = x_110._2;
        positionVar_9 = x_111
      }
    else
      ()
  }));
  data_10
}).apply();
  
  override def run_until(until_113: scala.Int) : meta.deep.runtime.Actor =  {
    while ({
      val x_114 = timeVar;
      val x_115 = x_114.<=(until_113);
      x_115.&&({
        val x_116 = positionVar_9;
        val x_117 = commands_112.length;
        x_116.<(x_117)
      })
    }) 
      {
        val x_118 = positionVar_9;
        val x_119 = commands_112.apply(x_118);
        x_119.apply()
      }
    ;
    this
  }
}

class TrafficLight extends TrafficLightTrait