package generated

trait PassengerTrait extends meta.deep.runtime.Actor with meta.example.supermarket.goods.newItem {
    var trafficLight: generated.TrafficLightTrait = null

    private var resetData_0: scala.Any = null;
  private val resetData_1 = scala.collection.mutable.ListBuffer.apply[scala.collection.immutable.List[scala.Tuple2[scala.Tuple2[scala.Int, scala.Int], scala.Int]]]();
  private var resetData_2: meta.deep.runtime.ResponseMessage = null;
  private var bindingMut_3: generated.TrafficLightTrait = null;
  private var bindingMut_4: scala.Boolean = false;
  private var bindingMut_5: scala.Int = 0;
  private var bindingMut_6: generated.TrafficLightTrait = null;
  private var bindingMut_7: scala.Boolean = false;
  private var bindingMut_8: scala.Boolean = false;
  private var bindingMut_9: scala.Int = 0;
  private var bindingMut_10: scala.util.Random = null;
  var timeVar: scala.Int = 0;
  private var positionVar_12: scala.Int = 0;
  
  val commands_83 = (() => {
  val data_13 = new scala.Array[scala.Function0[scala.Unit]](18);
  data_13.update(0, (() => positionVar_12 = 1));
  data_13.update(1, (() => if (true)
    positionVar_12 = 2
  else
    positionVar_12 = 17));
  data_13.update(2, (() => {
    val x_14 = new scala.util.Random();
    resetData_0 = x_14;
    val x_15 = resetData_0;
    val x_16 = x_15.asInstanceOf[scala.util.Random];
    bindingMut_10 = x_16;
    val x_17 = bindingMut_10;
    val x_18 = x_17.asInstanceOf[scala.util.Random];
    val x_19 = x_18.nextInt(3);
    resetData_0 = x_19;
    val x_20 = resetData_0;
    val x_21 = x_20.asInstanceOf[scala.Int];
    bindingMut_9 = x_21;
    val x_22 = bindingMut_9;
    val x_23 = x_22.asInstanceOf[scala.Int];
    val x_24 = x_23.==(1);
    resetData_0 = x_24;
    val x_25 = resetData_0;
    val x_26 = x_25.asInstanceOf[scala.Boolean];
    bindingMut_8 = x_26;
    val x_27 = bindingMut_8;
    val x_28 = x_27.asInstanceOf[scala.Boolean];
    val x_31 = x_28.||({
      val x_29 = bindingMut_9;
      val x_30 = x_29.asInstanceOf[scala.Int];
      x_30.==(3)
    });
    resetData_0 = x_31;
    val x_32 = resetData_0;
    val x_33 = x_32.asInstanceOf[scala.Boolean];
    bindingMut_7 = x_33;
    positionVar_12 = 3
  }));
  data_13.update(3, (() => {
    val x_34 = bindingMut_7;
    val x_35 = x_34.asInstanceOf[scala.Boolean];
    val x_36 = x_35.`unary_!`;
    if (x_36)
      positionVar_12 = 4
    else
      positionVar_12 = 10
  }));
  data_13.update(4, (() => {
    positionVar_12 = 5;
    val x_37 = timeVar;
    val x_38 = x_37.+(1);
    timeVar = x_38
  }));
  data_13.update(5, (() => if (true)
    positionVar_12 = 2
  else
    positionVar_12 = 6));
  data_13.update(6, (() => {
    val x_39 = true.`unary_!`;
    if (x_39)
      positionVar_12 = 7
    else
      ()
  }));
  data_13.update(7, (() => positionVar_12 = 8));
  data_13.update(8, (() => {
    positionVar_12 = 9;
    val x_40 = timeVar;
    val x_41 = x_40.+(1);
    timeVar = x_41
  }));
  data_13.update(9, (() => positionVar_12 = 8));
  data_13.update(10, (() => {
    val x_42 = bindingMut_7;
    val x_43 = x_42.asInstanceOf[scala.Boolean];
    if (x_43)
      {
        val x_44 = this.trafficLight;
        resetData_0 = x_44;
        val x_45 = resetData_0;
        val x_46 = x_45.asInstanceOf[generated.TrafficLightTrait];
        bindingMut_6 = x_46;
        val x_47 = bindingMut_6;
        val x_48 = x_47.asInstanceOf[generated.TrafficLightTrait];
        val x_49 = x_48.state;
        resetData_0 = x_49;
        val x_50 = resetData_0;
        val x_51 = x_50.asInstanceOf[scala.Int];
        bindingMut_5 = x_51;
        val x_52 = bindingMut_5;
        val x_53 = x_52.asInstanceOf[scala.Int];
        val x_54 = x_53.==(0);
        resetData_0 = x_54;
        val x_55 = resetData_0;
        val x_56 = x_55.asInstanceOf[scala.Boolean];
        bindingMut_4 = x_56;
        positionVar_12 = 11
      }
    else
      ()
  }));
  data_13.update(11, (() => {
    val x_57 = bindingMut_4;
    val x_58 = x_57.asInstanceOf[scala.Boolean];
    val x_59 = x_58.`unary_!`;
    if (x_59)
      {
        scala.Predef.println("Passenger is crossing the road");
        resetData_0 = ();
        positionVar_12 = 12
      }
    else
      positionVar_12 = 13
  }));
  data_13.update(12, (() => positionVar_12 = 4));
  data_13.update(13, (() => {
    val x_60 = bindingMut_4;
    val x_61 = x_60.asInstanceOf[scala.Boolean];
    if (x_61)
      {
        scala.Predef.println("passenger asks to cross the road!");
        resetData_0 = ();
        val x_62 = this.trafficLight;
        resetData_0 = x_62;
        val x_63 = resetData_0;
        val x_64 = x_63.asInstanceOf[generated.TrafficLightTrait];
        bindingMut_3 = x_64;
        val x_65 = ((this): meta.deep.runtime.Actor).id;
        val x_67 = {
          val x_66 = bindingMut_3;
          x_66.asInstanceOf[generated.TrafficLightTrait]
        };
        val x_68 = x_67.id;
        val x_69 = scala.collection.immutable.Nil.::[scala.collection.immutable.List[scala.Any]](((scala.collection.immutable.Nil): scala.collection.immutable.List[scala.Any]));
        val x_70 = meta.deep.runtime.RequestMessage.apply(x_65, x_68, 0, x_69);
        ((this): meta.deep.runtime.Actor).sendMessage(x_70);
        val x_71 = x_70.sessionId;
        ((this): meta.deep.runtime.Actor).setMessageResponseHandler(x_71, ((response_72: meta.deep.runtime.Message) => {
          val x_73 = response_72.asInstanceOf[meta.deep.runtime.ResponseMessage];
          resetData_2 = x_73
        }));
        resetData_0 = null;
        positionVar_12 = 14
      }
    else
      ()
  }));
  data_13.update(14, (() => {
    positionVar_12 = 15;
    val x_74 = timeVar;
    val x_75 = x_74.+(1);
    timeVar = x_75
  }));
  data_13.update(15, (() => {
    val x_76 = resetData_2;
    val x_77 = x_76.==(null);
    if (x_77)
      positionVar_12 = 14
    else
      positionVar_12 = 16
  }));
  data_13.update(16, (() => {
    val x_78 = resetData_2;
    val x_79 = x_78.!=(null);
    if (x_79)
      {
        val x_80 = resetData_2;
        val x_81 = x_80.arg;
        resetData_0 = x_81;
        resetData_2 = null;
        scala.Predef.println("Passenger is crossing the road");
        resetData_0 = ();
        positionVar_12 = 12
      }
    else
      ()
  }));
  data_13.update(17, (() => {
    val x_82 = true.`unary_!`;
    if (x_82)
      positionVar_12 = 7
    else
      ()
  }));
  data_13
}).apply();
  
  override def run_until(until_84: scala.Int) : meta.deep.runtime.Actor =  {
    while ({
      val x_85 = timeVar;
      val x_86 = x_85.<=(until_84);
      x_86.&&({
        val x_87 = positionVar_12;
        val x_88 = commands_83.length;
        x_87.<(x_88)
      })
    }) 
      {
        val x_89 = positionVar_12;
        val x_90 = commands_83.apply(x_89);
        x_90.apply()
      }
    ;
    this
  }
}

class Passenger extends PassengerTrait