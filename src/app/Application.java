package app;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[]bla) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Entre com o nome do departamento: ");
        String departmentName = scanner.nextLine();
        System.out.println("Entre com os dados do trabalhador");
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Nivel: ");
        String workerLevel = scanner.nextLine();
        System.out.print("Base salarial: ");
        double baseSalary = scanner.nextDouble();

        Worker worker = new Worker(
                name,WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

        System.out.print("Número de contratos: ");
        int numberContracts = scanner.nextInt();
        for (int i = 0; i < numberContracts; i++) {
            System.out.print("Contrato #" + (i + 1) + ": ");
            System.out.print("Data do contrato(DD/MM/YYYY): ");
            Date date = simpleDateFormat.parse(scanner.next());
            System.out.print("Valor por hora: ");
            double value = scanner.nextDouble();
            System.out.print("Quantidade de horas: ");
            int hoursQuantity = scanner.nextInt();

            HourContract contract = new HourContract(date,value, hoursQuantity);
            worker.addContract(contract);


        }
        System.out.println();
        System.out.print("Entre com DD/MM p/ calcular o valor a ser recebido: ");
        String date = scanner.next();
        int month = Integer.parseInt(date.substring(0, 2));
        int year = Integer.parseInt(date.substring(3));

        System.out.print("Funcionario " + worker.getName() + ": ");
        System.out.print("Valor final a ser recebido: " + worker.income(year, month));

        scanner.close();
    }
}
