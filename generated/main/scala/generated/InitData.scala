package generated

object InitData  {
  def initActors: List[meta.deep.runtime.Actor] = {{
  val l_0 = scala.collection.mutable.ListBuffer.apply[meta.deep.runtime.Actor]();
  val l_repeat_1 = scala.collection.mutable.ListBuffer.apply[meta.deep.runtime.Actor]();
  val x_2 = scala.Predef.intWrapper(1);
  val x_3 = x_2.to(5);
  x_3.foreach[scala.Unit](((x$1_4: scala.Int) => {
    val x_5 = new generated.Customer1();
    l_repeat_1.append(x_5)
  }));
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_6 = scala.Predef.intWrapper(1);
  val x_7 = x_6.to(10);
  x_7.foreach[scala.Unit](((x$2_8: scala.Int) => {
    val x_9 = new generated.Item1();
    l_repeat_1.append(x_9)
  }));
  val x_10 = l_repeat_1.toVector;
  val x_11 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_13 = x_10.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$3_12: meta.deep.runtime.Actor) => x$3_12.asInstanceOf[meta.example.supermarket.goods.Item]))(x_11);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_13);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_14 = scala.Predef.intWrapper(1);
  val x_15 = x_14.to(10);
  x_15.foreach[scala.Unit](((x$4_16: scala.Int) => {
    val x_17 = new generated.Item2();
    l_repeat_1.append(x_17)
  }));
  val x_18 = l_repeat_1.toVector;
  val x_19 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_21 = x_18.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$5_20: meta.deep.runtime.Actor) => x$5_20.asInstanceOf[meta.example.supermarket.goods.Item]))(x_19);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_21);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_22 = scala.Predef.intWrapper(1);
  val x_23 = x_22.to(10);
  x_23.foreach[scala.Unit](((x$6_24: scala.Int) => {
    val x_25 = new generated.Item3();
    l_repeat_1.append(x_25)
  }));
  val x_26 = l_repeat_1.toVector;
  val x_27 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_29 = x_26.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$7_28: meta.deep.runtime.Actor) => x$7_28.asInstanceOf[meta.example.supermarket.goods.Item]))(x_27);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_29);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_30 = scala.Predef.intWrapper(1);
  val x_31 = x_30.to(10);
  x_31.foreach[scala.Unit](((x$8_32: scala.Int) => {
    val x_33 = new generated.Item4();
    l_repeat_1.append(x_33)
  }));
  val x_34 = l_repeat_1.toVector;
  val x_35 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_37 = x_34.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$9_36: meta.deep.runtime.Actor) => x$9_36.asInstanceOf[meta.example.supermarket.goods.Item]))(x_35);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_37);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_38 = scala.Predef.intWrapper(1);
  val x_39 = x_38.to(10);
  x_39.foreach[scala.Unit](((x$10_40: scala.Int) => {
    val x_41 = new generated.Item5();
    l_repeat_1.append(x_41)
  }));
  val x_42 = l_repeat_1.toVector;
  val x_43 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_45 = x_42.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$11_44: meta.deep.runtime.Actor) => x$11_44.asInstanceOf[meta.example.supermarket.goods.Item]))(x_43);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_45);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_46 = scala.Predef.intWrapper(1);
  val x_47 = x_46.to(10);
  x_47.foreach[scala.Unit](((x$12_48: scala.Int) => {
    val x_49 = new generated.Item6();
    l_repeat_1.append(x_49)
  }));
  val x_50 = l_repeat_1.toVector;
  val x_51 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_53 = x_50.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$13_52: meta.deep.runtime.Actor) => x$13_52.asInstanceOf[meta.example.supermarket.goods.Item]))(x_51);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_53);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_54 = scala.Predef.intWrapper(1);
  val x_55 = x_54.to(10);
  x_55.foreach[scala.Unit](((x$14_56: scala.Int) => {
    val x_57 = new generated.Item7();
    l_repeat_1.append(x_57)
  }));
  val x_58 = l_repeat_1.toVector;
  val x_59 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_61 = x_58.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$15_60: meta.deep.runtime.Actor) => x$15_60.asInstanceOf[meta.example.supermarket.goods.Item]))(x_59);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_61);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_62 = scala.Predef.intWrapper(1);
  val x_63 = x_62.to(10);
  x_63.foreach[scala.Unit](((x$16_64: scala.Int) => {
    val x_65 = new generated.Item8();
    l_repeat_1.append(x_65)
  }));
  val x_66 = l_repeat_1.toVector;
  val x_67 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_69 = x_66.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$17_68: meta.deep.runtime.Actor) => x$17_68.asInstanceOf[meta.example.supermarket.goods.Item]))(x_67);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_69);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_70 = scala.Predef.intWrapper(1);
  val x_71 = x_70.to(10);
  x_71.foreach[scala.Unit](((x$18_72: scala.Int) => {
    val x_73 = new generated.Item9();
    l_repeat_1.append(x_73)
  }));
  val x_74 = l_repeat_1.toVector;
  val x_75 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_77 = x_74.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$19_76: meta.deep.runtime.Actor) => x$19_76.asInstanceOf[meta.example.supermarket.goods.Item]))(x_75);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_77);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_78 = scala.Predef.intWrapper(1);
  val x_79 = x_78.to(10);
  x_79.foreach[scala.Unit](((x$20_80: scala.Int) => {
    val x_81 = new generated.Item10();
    l_repeat_1.append(x_81)
  }));
  val x_82 = l_repeat_1.toVector;
  val x_83 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_85 = x_82.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$21_84: meta.deep.runtime.Actor) => x$21_84.asInstanceOf[meta.example.supermarket.goods.Item]))(x_83);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_85);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_86 = scala.Predef.intWrapper(1);
  val x_87 = x_86.to(10);
  x_87.foreach[scala.Unit](((x$22_88: scala.Int) => {
    val x_89 = new generated.Item11();
    l_repeat_1.append(x_89)
  }));
  val x_90 = l_repeat_1.toVector;
  val x_91 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_93 = x_90.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$23_92: meta.deep.runtime.Actor) => x$23_92.asInstanceOf[meta.example.supermarket.goods.Item]))(x_91);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_93);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_94 = scala.Predef.intWrapper(1);
  val x_95 = x_94.to(10);
  x_95.foreach[scala.Unit](((x$24_96: scala.Int) => {
    val x_97 = new generated.Item12();
    l_repeat_1.append(x_97)
  }));
  val x_98 = l_repeat_1.toVector;
  val x_99 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_101 = x_98.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$25_100: meta.deep.runtime.Actor) => x$25_100.asInstanceOf[meta.example.supermarket.goods.Item]))(x_99);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_101);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_102 = scala.Predef.intWrapper(1);
  val x_103 = x_102.to(10);
  x_103.foreach[scala.Unit](((x$26_104: scala.Int) => {
    val x_105 = new generated.Item13();
    l_repeat_1.append(x_105)
  }));
  val x_106 = l_repeat_1.toVector;
  val x_107 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_109 = x_106.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$27_108: meta.deep.runtime.Actor) => x$27_108.asInstanceOf[meta.example.supermarket.goods.Item]))(x_107);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_109);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_110 = scala.Predef.intWrapper(1);
  val x_111 = x_110.to(10);
  x_111.foreach[scala.Unit](((x$28_112: scala.Int) => {
    val x_113 = new generated.Item14();
    l_repeat_1.append(x_113)
  }));
  val x_114 = l_repeat_1.toVector;
  val x_115 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_117 = x_114.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$29_116: meta.deep.runtime.Actor) => x$29_116.asInstanceOf[meta.example.supermarket.goods.Item]))(x_115);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_117);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_118 = scala.Predef.intWrapper(1);
  val x_119 = x_118.to(10);
  x_119.foreach[scala.Unit](((x$30_120: scala.Int) => {
    val x_121 = new generated.Item15();
    l_repeat_1.append(x_121)
  }));
  val x_122 = l_repeat_1.toVector;
  val x_123 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_125 = x_122.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$31_124: meta.deep.runtime.Actor) => x$31_124.asInstanceOf[meta.example.supermarket.goods.Item]))(x_123);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_125);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_126 = scala.Predef.intWrapper(1);
  val x_127 = x_126.to(10);
  x_127.foreach[scala.Unit](((x$32_128: scala.Int) => {
    val x_129 = new generated.Item16();
    l_repeat_1.append(x_129)
  }));
  val x_130 = l_repeat_1.toVector;
  val x_131 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_133 = x_130.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$33_132: meta.deep.runtime.Actor) => x$33_132.asInstanceOf[meta.example.supermarket.goods.Item]))(x_131);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_133);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_134 = scala.Predef.intWrapper(1);
  val x_135 = x_134.to(10);
  x_135.foreach[scala.Unit](((x$34_136: scala.Int) => {
    val x_137 = new generated.Item17();
    l_repeat_1.append(x_137)
  }));
  val x_138 = l_repeat_1.toVector;
  val x_139 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_141 = x_138.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$35_140: meta.deep.runtime.Actor) => x$35_140.asInstanceOf[meta.example.supermarket.goods.Item]))(x_139);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_141);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_142 = scala.Predef.intWrapper(1);
  val x_143 = x_142.to(10);
  x_143.foreach[scala.Unit](((x$36_144: scala.Int) => {
    val x_145 = new generated.Item18();
    l_repeat_1.append(x_145)
  }));
  val x_146 = l_repeat_1.toVector;
  val x_147 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_149 = x_146.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$37_148: meta.deep.runtime.Actor) => x$37_148.asInstanceOf[meta.example.supermarket.goods.Item]))(x_147);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_149);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_150 = scala.Predef.intWrapper(1);
  val x_151 = x_150.to(10);
  x_151.foreach[scala.Unit](((x$38_152: scala.Int) => {
    val x_153 = new generated.Item19();
    l_repeat_1.append(x_153)
  }));
  val x_154 = l_repeat_1.toVector;
  val x_155 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_157 = x_154.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$39_156: meta.deep.runtime.Actor) => x$39_156.asInstanceOf[meta.example.supermarket.goods.Item]))(x_155);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_157);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_158 = scala.Predef.intWrapper(1);
  val x_159 = x_158.to(10);
  x_159.foreach[scala.Unit](((x$40_160: scala.Int) => {
    val x_161 = new generated.Item20();
    l_repeat_1.append(x_161)
  }));
  val x_162 = l_repeat_1.toVector;
  val x_163 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_165 = x_162.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$41_164: meta.deep.runtime.Actor) => x$41_164.asInstanceOf[meta.example.supermarket.goods.Item]))(x_163);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_165);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_166 = scala.Predef.intWrapper(1);
  val x_167 = x_166.to(10);
  x_167.foreach[scala.Unit](((x$42_168: scala.Int) => {
    val x_169 = new generated.Item21();
    l_repeat_1.append(x_169)
  }));
  val x_170 = l_repeat_1.toVector;
  val x_171 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_173 = x_170.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$43_172: meta.deep.runtime.Actor) => x$43_172.asInstanceOf[meta.example.supermarket.goods.Item]))(x_171);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_173);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_174 = scala.Predef.intWrapper(1);
  val x_175 = x_174.to(10);
  x_175.foreach[scala.Unit](((x$44_176: scala.Int) => {
    val x_177 = new generated.Item22();
    l_repeat_1.append(x_177)
  }));
  val x_178 = l_repeat_1.toVector;
  val x_179 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_181 = x_178.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$45_180: meta.deep.runtime.Actor) => x$45_180.asInstanceOf[meta.example.supermarket.goods.Item]))(x_179);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_181);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_182 = scala.Predef.intWrapper(1);
  val x_183 = x_182.to(10);
  x_183.foreach[scala.Unit](((x$46_184: scala.Int) => {
    val x_185 = new generated.Item23();
    l_repeat_1.append(x_185)
  }));
  val x_186 = l_repeat_1.toVector;
  val x_187 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_189 = x_186.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$47_188: meta.deep.runtime.Actor) => x$47_188.asInstanceOf[meta.example.supermarket.goods.Item]))(x_187);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_189);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_190 = scala.Predef.intWrapper(1);
  val x_191 = x_190.to(10);
  x_191.foreach[scala.Unit](((x$48_192: scala.Int) => {
    val x_193 = new generated.Item24();
    l_repeat_1.append(x_193)
  }));
  val x_194 = l_repeat_1.toVector;
  val x_195 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_197 = x_194.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$49_196: meta.deep.runtime.Actor) => x$49_196.asInstanceOf[meta.example.supermarket.goods.Item]))(x_195);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_197);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_198 = scala.Predef.intWrapper(1);
  val x_199 = x_198.to(10);
  x_199.foreach[scala.Unit](((x$50_200: scala.Int) => {
    val x_201 = new generated.Item25();
    l_repeat_1.append(x_201)
  }));
  val x_202 = l_repeat_1.toVector;
  val x_203 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_205 = x_202.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$51_204: meta.deep.runtime.Actor) => x$51_204.asInstanceOf[meta.example.supermarket.goods.Item]))(x_203);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_205);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_206 = scala.Predef.intWrapper(1);
  val x_207 = x_206.to(10);
  x_207.foreach[scala.Unit](((x$52_208: scala.Int) => {
    val x_209 = new generated.Item26();
    l_repeat_1.append(x_209)
  }));
  val x_210 = l_repeat_1.toVector;
  val x_211 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_213 = x_210.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$53_212: meta.deep.runtime.Actor) => x$53_212.asInstanceOf[meta.example.supermarket.goods.Item]))(x_211);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_213);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_214 = scala.Predef.intWrapper(1);
  val x_215 = x_214.to(10);
  x_215.foreach[scala.Unit](((x$54_216: scala.Int) => {
    val x_217 = new generated.Item27();
    l_repeat_1.append(x_217)
  }));
  val x_218 = l_repeat_1.toVector;
  val x_219 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_221 = x_218.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$55_220: meta.deep.runtime.Actor) => x$55_220.asInstanceOf[meta.example.supermarket.goods.Item]))(x_219);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_221);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_222 = scala.Predef.intWrapper(1);
  val x_223 = x_222.to(10);
  x_223.foreach[scala.Unit](((x$56_224: scala.Int) => {
    val x_225 = new generated.Item28();
    l_repeat_1.append(x_225)
  }));
  val x_226 = l_repeat_1.toVector;
  val x_227 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_229 = x_226.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$57_228: meta.deep.runtime.Actor) => x$57_228.asInstanceOf[meta.example.supermarket.goods.Item]))(x_227);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_229);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_230 = scala.Predef.intWrapper(1);
  val x_231 = x_230.to(10);
  x_231.foreach[scala.Unit](((x$58_232: scala.Int) => {
    val x_233 = new generated.Item29();
    l_repeat_1.append(x_233)
  }));
  val x_234 = l_repeat_1.toVector;
  val x_235 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_237 = x_234.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$59_236: meta.deep.runtime.Actor) => x$59_236.asInstanceOf[meta.example.supermarket.goods.Item]))(x_235);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_237);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_238 = scala.Predef.intWrapper(1);
  val x_239 = x_238.to(10);
  x_239.foreach[scala.Unit](((x$60_240: scala.Int) => {
    val x_241 = new generated.Item30();
    l_repeat_1.append(x_241)
  }));
  val x_242 = l_repeat_1.toVector;
  val x_243 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_245 = x_242.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$61_244: meta.deep.runtime.Actor) => x$61_244.asInstanceOf[meta.example.supermarket.goods.Item]))(x_243);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_245);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  val x_246 = scala.Predef.intWrapper(1);
  val x_247 = x_246.to(10);
  x_247.foreach[scala.Unit](((x$62_248: scala.Int) => {
    val x_249 = new generated.Item31();
    l_repeat_1.append(x_249)
  }));
  val x_250 = l_repeat_1.toVector;
  val x_251 = scala.collection.immutable.Vector.canBuildFrom[meta.example.supermarket.goods.Item];
  val x_253 = x_250.map[meta.example.supermarket.goods.Item, scala.collection.immutable.Vector[meta.example.supermarket.goods.Item]](((x$63_252: meta.deep.runtime.Actor) => x$63_252.asInstanceOf[meta.example.supermarket.goods.Item]))(x_251);
  meta.example.supermarket.Supermarket.store.initializeItemDeque(x_253);
  l_0.++=(l_repeat_1);
  l_repeat_1.clear();
  l_0.toList
}}
}