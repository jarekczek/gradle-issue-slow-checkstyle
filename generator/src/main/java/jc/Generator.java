package jc;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;

class Generator {

    private void generate(String name) throws IOException {
        TypeSpec c = TypeSpec.classBuilder(name)
            .addModifiers(Modifier.PUBLIC)
            .addMethod(MethodSpec.methodBuilder("calc").build())
            .build();
        JavaFile javaFile = JavaFile.builder("jc.generated", c).build();
        javaFile.writeTo(new File("../src/main/java"));
    }

    public static void main(String[] args) throws IOException {
        System.out.println("starting generator");
        for (int i = 1; i <= 400; i++) {
            new Generator().generate(String.format("Plain%03d", i));
        }
    }
}
