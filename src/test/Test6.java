package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> totalList = new ArrayList<Integer>();
		ArrayList<Integer> knownList = new ArrayList<Integer>();
		ArrayList<ArrayList<Relationship>> rList = new ArrayList<ArrayList<Relationship>>();
		int count = scanner.nextInt();
		for(int i = 0;i<count;i++){
			int total = scanner.nextInt();
			int known = scanner.nextInt();
			totalList.add(total);
			knownList.add(known);
			ArrayList<Relationship> relationships = new ArrayList<Relationship>();
			for(int j = 0;j<known;j++){
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				Relationship r = new Relationship(a, b);
				relationships.add(r);
				rList.add(relationships);
			}
		}
		for(int i = 0;i<count;i++){
			int known = knownList.get(i);
			if(0 == known){
				System.out.println(0);
				System.out.println();
			} else {
				int total = totalList.get(i);
				ArrayList<Relationship> relationships = rList.get(i);
				ArrayList<Integer> winners = new ArrayList<Integer>();
				ArrayList<Integer> candidateIds = new ArrayList<Integer>();
				Candidate[] candidates = new Candidate[total];
				for(int k = 0;k<relationships.size();k++){
					Relationship r = relationships.get(k);
					int from = r.getFrom();
					int to = r.getTo();
					if(from == to){
						continue;
					}
					if(!candidateIds.contains(from-1)){
						candidateIds.add(from - 1);
						candidates[from - 1] = new Candidate();
					}
					if(!candidateIds.contains(to - 1)){
						candidateIds.add(to - 1);
						candidates[to - 1] = new Candidate();
					}
					candidates[from - 1].knowing();
					candidates[to - 1].beKnown();
				}
				for(int p = 0;p<candidates.length;p++){
					if(candidates[p].getKnows() != 0){
						continue;
					} else if(candidates[p].getKnown() != total - 1){
						continue;
					} else {
						winners.add(p);
					}
				}
				if(winners.size() == 0){
					System.out.println(0);
					System.out.println();
				} else {
					System.out.println(winners.size());
					StringBuilder builder = new StringBuilder();
					for(int q = 0;q<winners.size();q++){
						if(q != 0){
							builder.append(" ");
						}
						builder.append(q+1);
					}
					System.out.println(builder);
				}
			}
		}
	}
}
class Relationship{
	private Integer from;
	private Integer to;
	public Relationship(Integer from, Integer to) {
		super();
		this.from = from;
		this.to = to;
	}
	public Integer getFrom() {
		return from;
	}
	public void setFrom(Integer from) {
		this.from = from;
	}
	public Integer getTo() {
		return to;
	}
	public void setTo(Integer to) {
		this.to = to;
	}
}
class Candidate{
	private Integer known;
	private Integer knows;
	public Candidate(){known = knows = 0;}
	public Candidate(Integer id, Integer known, Integer knows) {
		super();
		this.known = known;
		this.knows = knows;
	}
	public void knowing(){
		knows++;
	}
	public void beKnown(){
		known++;
	}
	public Integer getKnown() {
		return known;
	}
	public void setKnown(Integer known) {
		this.known = known;
	}
	public Integer getKnows() {
		return knows;
	}
	public void setKnows(Integer knows) {
		this.knows = knows;
	}
}