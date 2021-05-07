/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.me.dao.EquipmentDAO;
import com.me.dao.DungeonDAO;
import com.me.dao.DungeonMonsterPairDAO;
import com.mycompany.pojo.Monster;
import com.me.dao.MonsterDAO;
import com.mycompany.pojo.Dungeon;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jian Xiao
 */
@Controller
public class GMController {

    @RequestMapping(value = "/GM_Main.htm", method = RequestMethod.POST)
    public ModelAndView GM_Main(HttpServletRequest request, HttpServletResponse response, MonsterDAO monsterDAO,
            DungeonDAO dungeonDAO, DungeonMonsterPairDAO dungeonMonsterPairDAO, EquipmentDAO equipmentDAO) {
        String choice = "default";
        if (request.getParameter("choice") != null) {
            choice = (String) request.getParameter("choice");
        }
        System.out.println(choice);
        switch (choice) {
            case "monster":
                request.setAttribute("monsters", monsterDAO.getAllMonsters());
                System.out.println(monsterDAO.getAllMonsters());
                return new ModelAndView("GM_Monster");
            case "dungeon":
                request.setAttribute("dungeons", dungeonDAO.getAllDungeons());
                return new ModelAndView("GM_Dungeon");
            case "dungeon_monster":
                request.setAttribute("DungeonMonsterPairs", dungeonMonsterPairDAO.getAllDungeonMonsterPairs());
                request.setAttribute("dungeons", dungeonDAO.getAllDungeons());
                request.setAttribute("monsters", monsterDAO.getAllMonsters());
                return new ModelAndView("GM_DungeonMonsterPair");
            case "equipment":
                request.setAttribute("monsters", monsterDAO.getAllMonsters());
                request.setAttribute("equipments", equipmentDAO.getAllEquipments());
                return new ModelAndView("GM_Equipment");
        }
        return new ModelAndView("GM_Main", "msg", "Somthing Wrong");
    }

    @RequestMapping(value = "/GM_Main.htm", method = RequestMethod.GET)
    public ModelAndView GM_Main_Get(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("GM_Main");
    }

    @RequestMapping(value = "/GM_Monster.htm", method = RequestMethod.POST)
    public ModelAndView GM_Monster(HttpServletRequest request, HttpServletResponse response, MonsterDAO monsterDAO) {
        //create
        if (!request.getParameter("name2").isEmpty()
                && !request.getParameter("lvl2").isEmpty()
                && !request.getParameter("hp2").isEmpty()
                && !request.getParameter("atk2").isEmpty()
                && !request.getParameter("def2").isEmpty()
                && !request.getParameter("spd2").isEmpty()
                && !request.getParameter("exp2").isEmpty()
                && !request.getParameter("loot2").isEmpty()) {
            String name = (String) request.getParameter("name2");
            int lvl = Integer.valueOf(request.getParameter("lvl2"));
            int hp = Integer.valueOf(request.getParameter("hp2"));
            int atk = Integer.valueOf(request.getParameter("atk2"));
            int def = Integer.valueOf(request.getParameter("def2"));
            int spd = Integer.valueOf(request.getParameter("spd2"));
            int exp = Integer.valueOf(request.getParameter("exp2"));
            int loot = Integer.valueOf(request.getParameter("loot2"));
            Monster m = new Monster(name, lvl, hp, atk, def, spd, exp, loot);
            System.out.println(m.toString());
            monsterDAO.addMonster(m);
        }

        String[] names = request.getParameterValues("name");
        String[] lvls = request.getParameterValues("lvl");
        String[] hps = request.getParameterValues("hp");
        String[] atks = request.getParameterValues("atk");
        String[] defs = request.getParameterValues("def");
        String[] spds = request.getParameterValues("spd");
        String[] exps = request.getParameterValues("exp");
        String[] loots = request.getParameterValues("loot");
        //update
        String[] toUpdate = request.getParameterValues("toUpdate");
        if (toUpdate != null) {
            int[] ids = new int[toUpdate.length];
            int[] indexs = new int[toUpdate.length];
            for (int i = 0; i < toUpdate.length; i++) {
                String[] temp = toUpdate[i].split(",");
                ids[i] = Integer.parseInt(temp[0]);
                indexs[i] = Integer.parseInt(temp[1]);
            }

            for (int i = 0; i < ids.length; i++) {
                Monster m = new Monster(
                        ids[i],
                        names[indexs[i]],
                        Integer.parseInt(lvls[indexs[i]]),
                        Integer.parseInt(hps[indexs[i]]),
                        Integer.parseInt(atks[indexs[i]]),
                        Integer.parseInt(defs[indexs[i]]),
                        Integer.parseInt(spds[indexs[i]]),
                        Integer.parseInt(exps[indexs[i]]),
                        Integer.parseInt(loots[indexs[i]]));
                monsterDAO.updateMonster(m);
            }
        }

        //remove
        String[] toRemove = request.getParameterValues("toRemove");
        if (toRemove != null) {
            int[] ids = new int[toRemove.length];
            int[] indexs = new int[toRemove.length];
            for (int i = 0; i < toRemove.length; i++) {
                String[] temp = toRemove[i].split(",");
                ids[i] = Integer.parseInt(temp[0]);
                indexs[i] = Integer.parseInt(temp[1]);
            }

            for (int i = 0; i < ids.length; i++) {
                Monster m = new Monster(
                        ids[i],
                        names[indexs[i]],
                        Integer.parseInt(lvls[indexs[i]]),
                        Integer.parseInt(hps[indexs[i]]),
                        Integer.parseInt(atks[indexs[i]]),
                        Integer.parseInt(defs[indexs[i]]),
                        Integer.parseInt(spds[indexs[i]]),
                        Integer.parseInt(exps[indexs[i]]),
                        Integer.parseInt(loots[indexs[i]]));
                try {
                    monsterDAO.deleteMonster(m);
                } catch (Exception ex) {

                }
            }
        }
        request.setAttribute("monsters", monsterDAO.getAllMonsters());
        return new ModelAndView("GM_Monster");
    }

    @RequestMapping(value = "/GM_Dungeon.htm", method = RequestMethod.POST)
    public ModelAndView GM_Dungeonr(HttpServletRequest request, HttpServletResponse response, DungeonDAO dungeonDAO) {
        //create
        if (!request.getParameter("name2").isEmpty()
                && !request.getParameter("lvl2").isEmpty()
                && !request.getParameter("waves2").isEmpty()) {
            String name = (String) request.getParameter("name2");
            int lvl = Integer.valueOf(request.getParameter("lvl2"));
            int waves = Integer.valueOf(request.getParameter("waves2"));
            Dungeon d = new Dungeon(name, lvl, waves);
            System.out.println(d.toString());
            dungeonDAO.addDungeon(d);
        }

        String[] names = request.getParameterValues("name");
        String[] lvls = request.getParameterValues("lvl");
        String[] waves = request.getParameterValues("waves");
        //update
        String[] toUpdate = request.getParameterValues("toUpdate");
        if (toUpdate != null) {
            int[] ids = new int[toUpdate.length];
            int[] indexs = new int[toUpdate.length];
            for (int i = 0; i < toUpdate.length; i++) {
                String[] temp = toUpdate[i].split(",");
                ids[i] = Integer.parseInt(temp[0]);
                indexs[i] = Integer.parseInt(temp[1]);
            }

            for (int i = 0; i < ids.length; i++) {
                Dungeon d = new Dungeon(
                        ids[i],
                        names[indexs[i]],
                        Integer.parseInt(lvls[indexs[i]]),
                        Integer.parseInt(waves[indexs[i]]));
                dungeonDAO.updateDungeon(d);
            }
        }

        //remove
        String[] toRemove = request.getParameterValues("toRemove");
        if (toRemove != null) {
            int[] ids = new int[toRemove.length];
            int[] indexs = new int[toRemove.length];
            for (int i = 0; i < toRemove.length; i++) {
                String[] temp = toRemove[i].split(",");
                ids[i] = Integer.parseInt(temp[0]);
                indexs[i] = Integer.parseInt(temp[1]);
            }

            for (int i = 0; i < ids.length; i++) {
                Dungeon d = new Dungeon(
                        ids[i],
                        names[indexs[i]],
                        Integer.parseInt(lvls[indexs[i]]),
                        Integer.parseInt(waves[indexs[i]]));
                try {
                    dungeonDAO.deleteDungeon(d);
                } catch (Exception ex) {

                }
            }
        }
        request.setAttribute("dungeons", dungeonDAO.getAllDungeons());
        return new ModelAndView("GM_Dungeon");
    }

    @RequestMapping(value = "/GM_DungeonMonsterPair.htm", method = RequestMethod.POST)
    public ModelAndView GM_DungeonrMonsterPair(HttpServletRequest request, HttpServletResponse response, DungeonMonsterPairDAO dungeonMonsterPairDAO, MonsterDAO monsterDAO, DungeonDAO dungeonDAO) {
        //create
        if (!request.getParameter("dungeonID2").isEmpty()
                && !request.getParameter("monsterID2").isEmpty()
                && !request.getParameter("wave2").isEmpty()) {
            int dungeonID = Integer.valueOf(request.getParameter("dungeonID2"));
            int monsterID = Integer.valueOf(request.getParameter("monsterID2"));
            int wave = Integer.valueOf(request.getParameter("wave2"));
            dungeonMonsterPairDAO.addDungeonMonsterPair(dungeonID, monsterID, wave);
        }

        String[] dungeonIDs = request.getParameterValues("dungeonID");
        String[] monsterIDs = request.getParameterValues("monsterID");
        String[] waves = request.getParameterValues("wave");
        //update
        String[] toUpdate = request.getParameterValues("toUpdate");
        if (toUpdate != null) {
            int[] ids = new int[toUpdate.length];
            int[] indexs = new int[toUpdate.length];
            for (int i = 0; i < toUpdate.length; i++) {
                String[] temp = toUpdate[i].split(",");
                ids[i] = Integer.parseInt(temp[0]);
                indexs[i] = Integer.parseInt(temp[1]);
            }

            for (int i = 0; i < ids.length; i++) {
                dungeonMonsterPairDAO.updateDungeonMonsterPair(
                        ids[i],
                        Integer.parseInt(dungeonIDs[indexs[i]]),
                        Integer.parseInt(monsterIDs[indexs[i]]),
                        Integer.parseInt(waves[indexs[i]]));
            }
        }

        //remove
        String[] toRemove = request.getParameterValues("toRemove");
        if (toRemove != null) {
            int[] ids = new int[toRemove.length];
            int[] indexs = new int[toRemove.length];
            for (int i = 0; i < toRemove.length; i++) {
                String[] temp = toRemove[i].split(",");
                ids[i] = Integer.parseInt(temp[0]);
                indexs[i] = Integer.parseInt(temp[1]);
            }

            for (int i = 0; i < ids.length; i++) {
                try {
                    dungeonMonsterPairDAO.deleteDungeonMonsterPair(
                            ids[i],
                            Integer.parseInt(dungeonIDs[indexs[i]]),
                            Integer.parseInt(monsterIDs[indexs[i]]),
                            Integer.parseInt(waves[indexs[i]]));
                } catch (Exception ex) {
                    System.out.println(ex);
                    request.setAttribute("deleteF", true);
                }
            }
        }
        request.setAttribute("DungeonMonsterPairs", dungeonMonsterPairDAO.getAllDungeonMonsterPairs());
        request.setAttribute("dungeons", dungeonDAO.getAllDungeons());
        request.setAttribute("monsters", monsterDAO.getAllMonsters());
        return new ModelAndView("GM_DungeonMonsterPair");
    }

    @RequestMapping(value = "/GM_Equipment.htm", method = RequestMethod.POST)
    public ModelAndView GM_Equipment(HttpServletRequest request, HttpServletResponse response, EquipmentDAO equipmentDAO) {
        //create
        if (!request.getParameter("name2").isEmpty()
                && !request.getParameter("part2").isEmpty()
                && !request.getParameter("atk2").isEmpty()
                && !request.getParameter("def2").isEmpty()
                && !request.getParameter("spd2").isEmpty()
                && !request.getParameter("value2").isEmpty()) {
            String name = request.getParameter("name2");
            String part = request.getParameter("part2");
            int atk = Integer.valueOf(request.getParameter("atk2"));
            int def = Integer.valueOf(request.getParameter("def2"));
            int spd = Integer.valueOf(request.getParameter("spd2"));
            int value = Integer.valueOf(request.getParameter("value2"));

            try {
                equipmentDAO.addEquipment(name, part, atk, def, spd, value);
            } catch (Exception e) {
                request.setAttribute("addF", true);
            }
        }

        String[] names = request.getParameterValues("name");
        String[] parts = request.getParameterValues("part");
        String[] atks = request.getParameterValues("atk");
        String[] defs = request.getParameterValues("def");
        String[] spds = request.getParameterValues("spd");
        String[] values = request.getParameterValues("value");
        //update
        String[] toUpdate = request.getParameterValues("toUpdate");
        System.out.println(toUpdate);
        if (toUpdate != null) {
            int[] ids = new int[toUpdate.length];
            int[] indexs = new int[toUpdate.length];
            for (int i = 0; i < toUpdate.length; i++) {
                String[] temp = toUpdate[i].split(",");
                ids[i] = Integer.parseInt(temp[0]);
                indexs[i] = Integer.parseInt(temp[1]);
            }

            for (int i = 0; i < indexs.length; i++) {
                equipmentDAO.updateEquipment(
                        ids[i],
                        names[indexs[i]],
                        parts[indexs[i]],
                        Integer.parseInt(atks[indexs[i]]),
                        Integer.parseInt(defs[indexs[i]]),
                        Integer.parseInt(spds[indexs[i]]),
                        Integer.parseInt(values[indexs[i]]));
            }
        }

        //remove
        String[] toRemove = request.getParameterValues("toRemove");
        if (toRemove != null) {
            int[] ids = new int[toRemove.length];
            int[] indexs = new int[toRemove.length];
            for (int i = 0; i < toRemove.length; i++) {
                String[] temp = toRemove[i].split(",");
                ids[i] = Integer.parseInt(temp[0]);
                indexs[i] = Integer.parseInt(temp[1]);
            }
            for (int i = 0; i < indexs.length; i++) {
                try {
                    equipmentDAO.deleteEquipment(
                            ids[i],
                            names[indexs[i]],
                            parts[indexs[i]],
                            Integer.parseInt(atks[indexs[i]]),
                            Integer.parseInt(defs[indexs[i]]),
                            Integer.parseInt(spds[indexs[i]]),
                            Integer.parseInt(values[indexs[i]]));
                } catch (Exception ex) {
                    System.out.println(ex);
                    request.setAttribute("deleteF", true);
                }
            }
        }
        request.setAttribute("equipments", equipmentDAO.getAllEquipments());
        return new ModelAndView("GM_Equipment");
    }
}
