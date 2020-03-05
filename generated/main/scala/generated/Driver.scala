package generated

trait DriverTrait extends meta.deep.runtime.Actor with meta.example.supermarket.goods.newItem {
    var trafficLight: generated.TrafficLightTrait = null

    private var resetData_0: scala.Any = null;
  private val resetData_1 = scala.collection.mutable.ListBuffer.apply[scala.collection.immutable.List[scala.Tuple2[scala.Tuple2[scala.Int, scala.Int], scala.Int]]]();
  private var resetData_2: meta.deep.runtime.ResponseMessage = null;
  private var bindingMut_3: generated.TrafficLightTrait = null;
  private var bindingMut_4: scala.Boolean = false;
  private var bindingMut_5: scala.Int = 0;
  private var bindingMut_6: generated.TrafficLightTrait = null;
  var timeVar: scala.Int = 0;
  private var positionVar_8: scala.Int = 0;
  
  val commands_54 = (() => {
  val data_9 = new scala.Array[scala.Function0[scala.Unit]](15);
  data_9.update(0, (() => positionVar_8 = 1));
  data_9.update(1, (() => if (true)
    positionVar_8 = 2
  else
    positionVar_8 = 14));
  data_9.update(2, (() => {
    val x_10 = this.trafficLight;
    resetData_0 = x_10;
    val x_11 = resetData_0;
    val x_12 = x_11.asInstanceOf[generated.TrafficLightTrait];
    bindingMut_6 = x_12;
    val x_13 = bindingMut_6;
    val x_14 = x_13.asInstanceOf[generated.TrafficLightTrait];
    val x_15 = x_14.state;
    resetData_0 = x_15;
    val x_16 = resetData_0;
    val x_17 = x_16.asInstanceOf[scala.Int];
    bindingMut_5 = x_17;
    val x_18 = bindingMut_5;
    val x_19 = x_18.asInstanceOf[scala.Int];
    val x_20 = x_19.==(1);
    resetData_0 = x_20;
    val x_21 = resetData_0;
    val x_22 = x_21.asInstanceOf[scala.Boolean];
    bindingMut_4 = x_22;
    positionVar_8 = 3
  }));
  data_9.update(3, (() => {
    val x_23 = bindingMut_4;
    val x_24 = x_23.asInstanceOf[scala.Boolean];
    val x_25 = x_24.`unary_!`;
    if (x_25)
      {
        scala.Predef.println("Driver is crossing the road");
        resetData_0 = ();
        positionVar_8 = 4
      }
    else
      positionVar_8 = 10
  }));
  data_9.update(4, (() => {
    positionVar_8 = 5;
    val x_26 = timeVar;
    val x_27 = x_26.+(1);
    timeVar = x_27
  }));
  data_9.update(5, (() => if (true)
    positionVar_8 = 2
  else
    positionVar_8 = 6));
  data_9.update(6, (() => {
    val x_28 = true.`unary_!`;
    if (x_28)
      positionVar_8 = 7
    else
      ()
  }));
  data_9.update(7, (() => positionVar_8 = 8));
  data_9.update(8, (() => {
    positionVar_8 = 9;
    val x_29 = timeVar;
    val x_30 = x_29.+(1);
    timeVar = x_30
  }));
  data_9.update(9, (() => positionVar_8 = 8));
  data_9.update(10, (() => {
    val x_31 = bindingMut_4;
    val x_32 = x_31.asInstanceOf[scala.Boolean];
    if (x_32)
      {
        val x_33 = this.trafficLight;
        resetData_0 = x_33;
        val x_34 = resetData_0;
        val x_35 = x_34.asInstanceOf[generated.TrafficLightTrait];
        bindingMut_3 = x_35;
        val x_36 = ((this): meta.deep.runtime.Actor).id;
        val x_38 = {
          val x_37 = bindingMut_3;
          x_37.asInstanceOf[generated.TrafficLightTrait]
        };
        val x_39 = x_38.id;
        val x_40 = scala.collection.immutable.Nil.::[scala.collection.immutable.List[scala.Any]](((scala.collection.immutable.Nil): scala.collection.immutable.List[scala.Any]));
        val x_41 = meta.deep.runtime.RequestMessage.apply(x_36, x_39, 0, x_40);
        ((this): meta.deep.runtime.Actor).sendMessage(x_41);
        val x_42 = x_41.sessionId;
        ((this): meta.deep.runtime.Actor).setMessageResponseHandler(x_42, ((response_43: meta.deep.runtime.Message) => {
          val x_44 = response_43.asInstanceOf[meta.deep.runtime.ResponseMessage];
          resetData_2 = x_44
        }));
        resetData_0 = null;
        positionVar_8 = 11
      }
    else
      ()
  }));
  data_9.update(11, (() => {
    positionVar_8 = 12;
    val x_45 = timeVar;
    val x_46 = x_45.+(1);
    timeVar = x_46
  }));
  data_9.update(12, (() => {
    val x_47 = resetData_2;
    val x_48 = x_47.==(null);
    if (x_48)
      positionVar_8 = 11
    else
      positionVar_8 = 13
  }));
  data_9.update(13, (() => {
    val x_49 = resetData_2;
    val x_50 = x_49.!=(null);
    if (x_50)
      {
        val x_51 = resetData_2;
        val x_52 = x_51.arg;
        resetData_0 = x_52;
        resetData_2 = null;
        scala.Predef.println("Driver is crossing the road");
        resetData_0 = ();
        positionVar_8 = 4
      }
    else
      ()
  }));
  data_9.update(14, (() => {
    val x_53 = true.`unary_!`;
    if (x_53)
      positionVar_8 = 7
    else
      ()
  }));
  data_9
}).apply();
  
  override def run_until(until_55: scala.Int) : meta.deep.runtime.Actor =  {
    while ({
      val x_56 = timeVar;
      val x_57 = x_56.<=(until_55);
      x_57.&&({
        val x_58 = positionVar_8;
        val x_59 = commands_54.length;
        x_58.<(x_59)
      })
    }) 
      {
        val x_60 = positionVar_8;
        val x_61 = commands_54.apply(x_60);
        x_61.apply()
      }
    ;
    this
  }
}

class Driver extends DriverTrait