# Spotbugs bug

The point of this project if to showcase a bug in spotbugs. If you run `mvn site` you will see the following error
being printed on the console:
```
[INFO] Fork Value is true
     [java] The following errors occurred during analysis:
     [java]   Error processing opcode ldc_w @ 14 in jdk.nashorn.internal.objects.NativeArray.$clinit$ : ()V
     [java]     java.lang.UnsupportedOperationException: StaticConstant type not expected
     [java]       At edu.umd.cs.findbugs.OpcodeStack.pushByConstant(OpcodeStack.java:3220)
     [java]       At edu.umd.cs.findbugs.OpcodeStack.sawOpcode(OpcodeStack.java:1440)
     [java]       At edu.umd.cs.findbugs.bcel.OpcodeStackDetector.afterOpcode(OpcodeStackDetector.java:83)
     [java]       At edu.umd.cs.findbugs.visitclass.DismantleBytecode.visit(DismantleBytecode.java:880)
     [java]       At edu.umd.cs.findbugs.detect.FieldItemSummary.visit(FieldItemSummary.java:131)
     [java]       At edu.umd.cs.findbugs.visitclass.BetterVisitor.visitCode(BetterVisitor.java:218)
     [java]       At edu.umd.cs.findbugs.visitclass.PreorderVisitor.visitCode(PreorderVisitor.java:243)
     [java]       At edu.umd.cs.findbugs.bcel.OpcodeStackDetector.visitCode(OpcodeStackDetector.java:65)
     [java]       At org.apache.bcel.classfile.Code.accept(Code.java:131)
     [java]       At edu.umd.cs.findbugs.visitclass.PreorderVisitor.doVisitMethod(PreorderVisitor.java:315)
     [java]       At edu.umd.cs.findbugs.visitclass.PreorderVisitor.visitJavaClass(PreorderVisitor.java:397)
     [java]       At org.apache.bcel.classfile.JavaClass.accept(JavaClass.java:213)
     [java]       At edu.umd.cs.findbugs.BytecodeScanningDetector.visitClassContext(BytecodeScanningDetector.java:38)
     [java]       At edu.umd.cs.findbugs.DetectorToDetector2Adapter.visitClass(DetectorToDetector2Adapter.java:76)
     [java]       At edu.umd.cs.findbugs.FindBugs2.lambda$analyzeApplication$1(FindBugs2.java:1108)
     [java]       At java.util.concurrent.FutureTask.run(FutureTask.java:266)
     [java]       At edu.umd.cs.findbugs.CurrentThreadExecutorService.execute(CurrentThreadExecutorService.java:86)
     [java]       At java.util.concurrent.AbstractExecutorService.invokeAll(AbstractExecutorService.java:238)
     [java]       At edu.umd.cs.findbugs.FindBugs2.analyzeApplication(FindBugs2.java:1118)
     [java]       At edu.umd.cs.findbugs.FindBugs2.execute(FindBugs2.java:309)
     [java]       At edu.umd.cs.findbugs.FindBugs.runMain(FindBugs.java:395)
     [java]       At edu.umd.cs.findbugs.FindBugs2.main(FindBugs2.java:1231)
     [java]   Error processing opcode ldc_w @ 14 in jdk.nashorn.internal.objects.NativeArray.$clinit$ : ()V
     [java]     java.lang.UnsupportedOperationException: StaticConstant type not expected
     [java]       At edu.umd.cs.findbugs.OpcodeStack.pushByConstant(OpcodeStack.java:3220)
     [java]       At edu.umd.cs.findbugs.OpcodeStack.sawOpcode(OpcodeStack.java:1440)
     [java]       At edu.umd.cs.findbugs.bcel.OpcodeStackDetector.afterOpcode(OpcodeStackDetector.java:83)
     [java]       At edu.umd.cs.findbugs.visitclass.DismantleBytecode.visit(DismantleBytecode.java:880)
     [java]       At edu.umd.cs.findbugs.detect.FindNoSideEffectMethods.visit(FindNoSideEffectMethods.java:484)
     [java]       At edu.umd.cs.findbugs.visitclass.BetterVisitor.visitCode(BetterVisitor.java:218)
     [java]       At edu.umd.cs.findbugs.visitclass.PreorderVisitor.visitCode(PreorderVisitor.java:243)
     [java]       At edu.umd.cs.findbugs.bcel.OpcodeStackDetector.visitCode(OpcodeStackDetector.java:65)
     [java]       At org.apache.bcel.classfile.Code.accept(Code.java:131)
     [java]       At edu.umd.cs.findbugs.visitclass.PreorderVisitor.doVisitMethod(PreorderVisitor.java:315)
     [java]       At edu.umd.cs.findbugs.visitclass.PreorderVisitor.visitJavaClass(PreorderVisitor.java:397)
     [java]       At org.apache.bcel.classfile.JavaClass.accept(JavaClass.java:213)
     [java]       At edu.umd.cs.findbugs.BytecodeScanningDetector.visitClassContext(BytecodeScanningDetector.java:38)
     [java]       At edu.umd.cs.findbugs.DetectorToDetector2Adapter.visitClass(DetectorToDetector2Adapter.java:76)
     [java]       At edu.umd.cs.findbugs.FindBugs2.lambda$analyzeApplication$1(FindBugs2.java:1108)
     [java]       At java.util.concurrent.FutureTask.run(FutureTask.java:266)
     [java]       At edu.umd.cs.findbugs.CurrentThreadExecutorService.execute(CurrentThreadExecutorService.java:86)
     [java]       At java.util.concurrent.AbstractExecutorService.invokeAll(AbstractExecutorService.java:238)
     [java]       At edu.umd.cs.findbugs.FindBugs2.analyzeApplication(FindBugs2.java:1118)
     [java]       At edu.umd.cs.findbugs.FindBugs2.execute(FindBugs2.java:309)
     [java]       At edu.umd.cs.findbugs.FindBugs.runMain(FindBugs.java:395)
     [java]       At edu.umd.cs.findbugs.FindBugs2.main(FindBugs2.java:1231)
[INFO] Done SpotBugs Analysis....
```

The code that triggers the bug is in se.alipsa.spotbugsbug.ScriptRunner. I.e: the following instanceof check:
```java
if (result instanceof NativeArray) {
  System.out.println("This instanceof check fails with spotbugs");
}
```