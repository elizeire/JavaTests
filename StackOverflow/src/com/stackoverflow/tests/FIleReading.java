package com.stackoverflow.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FIleReading {
	List<Double> Mass1 = new ArrayList<>();
	List<Double> Mass2 = new ArrayList<>();
	List<Double> Volume = new ArrayList<>();
	List<Double> Height = new ArrayList<>();

	
	public static void main(String[] args) throws IOException {
		FIleReading fi = new FIleReading();
		fi.Reading("Alcohol", 2);
	}
	
	void Reading(String name, int sk) throws IOException {
		List<String> Material = new ArrayList<>();
		Material = Files.lines(Paths.get("files/26laboratorinis.txt")).filter(s -> s.contains(name))
				.map(s -> s.substring(sk)).collect(Collectors.toList());

		for (String number : Material) {

			String[] l = number.split(" ");
			Mass1.add(Double.parseDouble(l[0]));
			Mass2.add(Double.parseDouble(l[1]));
			Volume.add(Double.parseDouble(l[2]));
			Height.add(Double.parseDouble(l[3]));
		}

	}

	public void setMass1(List<Double> PAM) {
		this.Mass1 = PAM;
	}

	public void setMass2(List<Double> TAM) {
		this.Mass2 = TAM;
	}

	public void setVolume(List<Double> T) {
		this.Volume = T;
	}

	public void setHeight(List<Double> VSA) {
		this.Height = VSA;
	}

	public List<Double> getMass1() {
		return Mass1;
	}

	public List<Double> getMass2() {
		return Mass2;
	}

	public List<Double> getVolume() {
		return Volume;
	}

	public List<Double> getHeight() {
		return Height;
	}

}